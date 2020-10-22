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

    //Many to Many because many items x many categories
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="items_categories",
            joinColumns={@JoinColumn(name="item_id")},
            inverseJoinColumns={@JoinColumn(name="category_id")}
    )
    private List<ItemCategory> categories;

    @OneToMany(mappedBy = "item")
    private List<ChecklistItem> checklistAssoc;


    //Empty constructor - do not delete.edit
    public Item(){}

    public Item(long id, String title, String description, String location, String url_link, List<ItemCategory> categories, List<ChecklistItem> checklistAssoc) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.url_link = url_link;
        this.categories = categories;
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

    public List<ItemCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<ItemCategory> categories) {
        this.categories = categories;
    }

    public List<ChecklistItem> getChecklistAssoc() {
        return checklistAssoc;
    }

    public void setChecklistAssoc(List<ChecklistItem> checklistAssoc) {
        this.checklistAssoc = checklistAssoc;
    }
}