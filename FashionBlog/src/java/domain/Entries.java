package domain;
// Generated Oct 4, 2020 8:30:14 PM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entries generated by hbm2java
 */
@Entity
@Table(name = "Entries",
        catalog = "FashionBlog"
)
public class Entries implements java.io.Serializable {

    private int entryId;
    private Categories categories;
    private String heading;
    private Date published;
    private String imageName;
    private String imageCaption;
    private String author;
    private String content;

    public Entries() {
    }

    public Entries(int entryId, Categories categories, String heading, Date published) {
        this.entryId = entryId;
        this.categories = categories;
        this.heading = heading;
        this.published = published;
    }

    public Entries(int entryId, Categories categories, String heading, Date published, String imageName, String imageCaption, String author, String content) {
        this.entryId = entryId;
        this.categories = categories;
        this.heading = heading;
        this.published = published;
        this.imageName = imageName;
        this.imageCaption = imageCaption;
        this.author = author;
        this.content = content;
    }

    @Id

    @Column(name = "EntryID", unique = true, nullable = false)
    public int getEntryId() {
        return this.entryId;
    }

    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CategoryID", nullable = false)
    public Categories getCategories() {
        return this.categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    @Column(name = "Heading", nullable = false)
    public String getHeading() {
        return this.heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "Published", nullable = false, length = 10)
    public Date getPublished() {
        return this.published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    @Column(name = "ImageName")
    public String getImageName() {
        return "img/" + this.imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Column(name = "ImageCaption")
    public String getImageCaption() {
        return this.imageCaption;
    }

    public void setImageCaption(String imageCaption) {
        this.imageCaption = imageCaption;
    }

    @Column(name = "Author")
    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Column(name = "Content")
    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int hashCode() {
        return Objects.hash(entryId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Entries other = (Entries) obj;
        if (this.entryId != other.entryId) {
            return false;
        }
        return true;
    }

}
