/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import bean.Article;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.faces.context.FacesContext;

import service.IArticleService;

/**
 *
 * @author Camer
 */
@Stateless
@Local
@Alternative
public class ArticleDAO extends AbstractBaseDAO implements IArticleService {

    public ArticleDAO() {
        this(FacesContext.getCurrentInstance().getExternalContext().getInitParameter("jdbc-url"));
    }

    public ArticleDAO(String url) {
        super(url);
    }

    @Override
    public List<Article> getArticles(int page, int qual) {
        int str = page * qual - (qual - 1);
        int end = page * qual;
        List<Article> articles = new LinkedList();
        String query = "select * from ("
                + "select *, ROW_NUMBER() over (order by id) as rownumber from Article"
                + ") as articles "
                + "where articles.rownumber between ? and ?;";
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            openConnection();
            stm = connection.prepareStatement(query);
            stm.setInt(1, str);
            stm.setInt(2, end);
            rs = stm.executeQuery();
            while (rs.next()) {
                //(id, tile, img, summary, content)
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String img = "img/" + rs.getString("img");
                String sum = rs.getString("summary");
                String content = rs.getString("content");
                articles.add(new Article(id, title, img, content, sum));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stm != null) {
                    stm.close();
                }
                if (rs != null) {
                    rs.close();
                }
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return articles;
    }

    @Override
    public Article getArticleById(int id) {
        String query = "select * from Article where id = ?";
        Article article = new Article();
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            openConnection();
            stm = connection.prepareStatement(query);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                article.setId(rs.getInt("id"));
                article.setTitle(rs.getString("title"));
                article.setImgsrc("img/"+ rs.getString("img"));
                article.setSummary(rs.getString("sum"));
                article.setContent(rs.getString("content"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(rs != null) rs.close();
                if(stm != null) stm.close();
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return article;
    }

    @Override
    public int getQuantityOfArticle() {
        return 0;
    }

}