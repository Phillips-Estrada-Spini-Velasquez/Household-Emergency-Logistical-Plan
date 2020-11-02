package help.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(length = 255)
    private String description;

    @Column(nullable = false, length = 255)
    private String location;

    @Column(nullable = false, length = 255)
    private String url_link;

    @OneToMany(mappedBy = "item")
    private List<ChecklistItem> checklistAssoc;


    //Empty constructor - do not delete.edit
    public Item(){}

    public Item(long id, String title, String description, String location, String url_link, List<ChecklistItem> checklistAssoc) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.url_link = url_link;
        this.checklistAssoc = checklistAssoc;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUrl_link() {
        return url_link;
    }

    public void setUrl_link(String url_link) {
        this.url_link = url_link;
    }

    public List<ChecklistItem> getChecklistAssoc() {
        return checklistAssoc;
    }

    public void setChecklistAssoc(List<ChecklistItem> checklistAssoc) {
        this.checklistAssoc = checklistAssoc;
    }
}