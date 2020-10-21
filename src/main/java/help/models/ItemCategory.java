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
}
