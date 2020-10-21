package help.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "checklist_items")
@IdClass(ChecklistItemPK.class)
public class ChecklistItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Id
    @ManyToOne
    @JoinColumn(name = "checklist_id", referencedColumnName = "id")
    private Checklist checklist;

    @Id
    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private Item item;

    @Column(name = "is_checked")
    private boolean isChecked;

    @OneToOne
//    @Column(name = "checked_by")
    private User checkedBy;

    @Column(nullable = false)
    private Date date;

}
