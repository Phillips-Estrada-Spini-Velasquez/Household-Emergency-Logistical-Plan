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

    public Checklist(long id, String title, List<ChecklistItem> itemAssoc) {
        this.id = id;
        this.title = title;
        this.itemAssoc = itemAssoc;
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

    public List<ChecklistItem> getItemAssoc() {
        return itemAssoc;
    }

    public void setItemAssoc(List<ChecklistItem> itemAssoc) {
        this.itemAssoc = itemAssoc;
    }
}