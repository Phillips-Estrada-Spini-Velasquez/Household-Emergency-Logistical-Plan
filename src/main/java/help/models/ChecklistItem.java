package help.models;

import javax.persistence.*;

@Entity
@Table(name = "checklist_items")
@AssociationOverrides({
        @AssociationOverride(name = "checklist",
                joinColumns = @JoinColumn(name = "checklist_id")),
        @AssociationOverride(name = "pk.item",
                joinColumns = @JoinColumn(name = "item_id")) })
public class ChecklistItem {

    private String id;

    public ChecklistItem() {
    }

    public void setId(String id) {
        this.id = id;
    }

    @Id
    public String getId() {
        return id;
    }
}
