package domain;
// Generated Oct 7, 2020 4:25:53 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Categories generated by hbm2java
 */
@Entity
@Table(name="Categories"
    ,catalog="FashionBlog"
)
public class Categories  implements java.io.Serializable {


     private int categoryId;
     private String categoryName;
     private Set<Entries> entrieses = new HashSet<Entries>(0);

    public Categories() {
    }

	
    public Categories(int categoryId) {
        this.categoryId = categoryId;
    }
    public Categories(int categoryId, String categoryName, Set<Entries> entrieses) {
       this.categoryId = categoryId;
       this.categoryName = categoryName;
       this.entrieses = entrieses;
    }
   
     @Id 

    
    @Column(name="CategoryID", unique=true, nullable=false)
    public int getCategoryId() {
        return this.categoryId;
    }
    
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    
    @Column(name="CategoryName")
    public String getCategoryName() {
        return this.categoryName;
    }
    
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="categories")
    public Set<Entries> getEntrieses() {
        return this.entrieses;
    }
    
    public void setEntrieses(Set<Entries> entrieses) {
        this.entrieses = entrieses;
    }




}


