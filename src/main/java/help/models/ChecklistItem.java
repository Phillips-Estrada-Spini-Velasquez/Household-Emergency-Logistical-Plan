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

    public ChecklistItem(long id, Checklist checklist, Item item, boolean isChecked, User checkedBy, Date date) {
        this.id = id;
        this.checklist = checklist;
        this.item = item;
        this.isChecked = isChecked;
        this.checkedBy = checkedBy;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Checklist getChecklist() {
        return checklist;
    }

    public void setChecklist(Checklist checklist) {
        this.checklist = checklist;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public User getCheckedBy() {
        return checkedBy;
    }

    public void setCheckedBy(User checkedBy) {
        this.checkedBy = checkedBy;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
