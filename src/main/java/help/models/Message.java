package help.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CreationTimestamp
    private LocalDate createDate;

    @CreationTimestamp
    private LocalTime createTime;

    @UpdateTimestamp
    private LocalDate updateDate;

    @UpdateTimestamp
    private LocalTime updateTime;

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String body;

    //Messages to User will be many-to-one because many messages can be posted by one group
    @ManyToOne
    @JsonManagedReference
    @JoinColumn (name = "owner_id")
    private User owner;

    //Groups to User will be many-to-one because many messages can be posted by one group
    @ManyToOne
    @JoinColumn (name = "group_id")
    private Group group;

    //Do we need to add a group id (think we can pull group_id from user )

    // extract group id method



    //Empty constructor - do not delete/edit
    public Message(){}

    public Message(long id, LocalDate createDate, LocalTime createTime, LocalDate updateDate, LocalTime updateTime, String body, User owner, Group group) {
        this.id = id;
        this.createDate = createDate;
        this.createTime = createTime;
        this.updateDate = updateDate;
        this.updateTime = updateTime;
        this.body = body;
        this.owner = owner;
        this.group = group;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalTime createTime) {
        this.createTime = createTime;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public LocalTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalTime updateTime) {
        this.updateTime = updateTime;
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