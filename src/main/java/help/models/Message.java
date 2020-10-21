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
    @JoinColumn (name = "user_id")
    private User user;

    //Do we need to add a group id (think we can pull group_id from user )





    //Empty constructor - do not delete/edit
    public Message(){}

}