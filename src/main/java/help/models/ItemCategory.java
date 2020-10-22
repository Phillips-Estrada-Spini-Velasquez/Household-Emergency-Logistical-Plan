package help.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class ItemCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 255, unique = true)
    private String title;

    //Many to Many because many items x many categories
    @ManyToMany(mappedBy = "categories")
    private List<Item> items;

    //Empty constructor - do not delete/edit
    public ItemCategory(){}

    public ItemCategory(long id, String title, List<Item> items) {
        this.id = id;
        this.title = title;
        this.items = items;
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
