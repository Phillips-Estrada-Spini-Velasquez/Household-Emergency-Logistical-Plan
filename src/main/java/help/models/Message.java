package help.models;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CreationTimestamp
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String body;

    //Messages to User will be many-to-one because many messages can be posted by one group
    @ManyToOne
    @JoinColumn (name = "owner_id")
    private User owner;

    //Do we need to add a group id (think we can pull group_id from user )

    // extract group id method



    //Empty constructor - do not delete/edit
    public Message(){}

    public Message(long id, LocalDateTime createDateTime, LocalDateTime updateDateTime, String body, User user) {
        this.id = id;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
        this.body = body;
        this.owner = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User user) {
        this.owner = owner;
    }
}