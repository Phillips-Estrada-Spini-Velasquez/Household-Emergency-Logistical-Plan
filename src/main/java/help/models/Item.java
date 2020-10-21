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

    //omitted description - dont think we need since we have title

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


    //Empty constructor - do not delete.edit
    public Item(){}

}