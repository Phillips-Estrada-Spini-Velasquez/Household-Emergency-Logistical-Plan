package help.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "checklists")
public class Checklist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 255)
    private String title;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable (
//            name = "checklist_items",
//            joinColumns = {@JoinColumn(name = "checklist_id")},
//            inverseJoinColumns = {@JoinColumn(name = "item_id")}
//    )

    @OneToMany(mappedBy = "checklist")
    private List<ChecklistItem> itemAssoc;

    //Empty constructor - do not delete/edit
    public Checklist(){}

}