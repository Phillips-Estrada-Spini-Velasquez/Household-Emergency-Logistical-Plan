package help.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // does not need to be unique
    @Column(nullable = false, length = 255, unique = true)
    private String firstName;

    // does not need to be unique
    @Column(nullable = false, length = 255, unique = true)
    private String lastName;

    @Column(nullable = false, length = 255, unique = true)
    private String username;

    @Column(nullable = false, length = 255, unique = true)
    private String email;

    // does not need to be unique
    @Column(nullable = false, length = 255, unique = true)
    private String password;

    // can be null specifically for new user using invite form
    @Column(nullable = false, columnDefinition = "integer default 10")
    private long phone;

    // can be null specifically for new user using invite form
    // does not need to be unique
    @Column(nullable = false, length = 255, unique = true)
    private String streetAddress;

    // can be null specifically for new user using invite form
    // does not need to be unique
    @Column(nullable = false, length = 255, unique = true)
    private String city;

    // can be null specifically for new user using invite form
    // does not need to be unique
    @Column(nullable = false, length = 255, unique = true)
    private String state;

    // can be null specifically for new user using invite form
    @Column(nullable = false, columnDefinition = "integer default 9")
    private long zip;

    //Many to Many because many users x one group - casey suggested many to many but it makes me want to cry - lets discuss
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable (
            name = "users_groups",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "group_id")}
    )
    private List<Group> groups;

    // link to messages


    //Empty constructor - do not delete/edit
    public User() {
    }

}