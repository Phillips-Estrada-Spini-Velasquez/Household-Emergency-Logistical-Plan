package help.models;

import java.io.Serializable;


public class ChecklistItemPK implements Serializable {

    private Long checklist;
    private Long item;

    public ChecklistItemPK(Long checklist, Long item) {
        this.checklist = checklist;
        this.item = item;
    }

    public Long getChecklist() {
        return checklist;
    }

    public void setChecklist(Long checklist) {
        this.checklist = checklist;
    }

    public Long getItem() {
        return item;
    }

    public void setItem(Long item) {
        this.item = item;
    }
}
