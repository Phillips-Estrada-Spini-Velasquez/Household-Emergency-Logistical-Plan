package help.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "documents")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String url;

    // Many documents to One owner
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    // Many documents to One group
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonManagedReference
    @JoinColumn(name = "group_id")
    private Group group;

    public Document() {
    }

    public Document(long id, String url, User owner, Group group) {
        this.id = id;
        this.url = url;
        this.owner = owner;
        this.group = group;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
