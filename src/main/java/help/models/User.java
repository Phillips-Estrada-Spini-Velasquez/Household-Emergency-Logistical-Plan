package help.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 255)
    private String firstName;

    @Column(nullable = false, length = 255)
    private String lastName;

    @Column(nullable = false, length = 255, unique = true)
    private String username;

    @Column(nullable = false, length = 255, unique = true)
    private String email;

    @Column(nullable = false, length = 255)
    private String password;

    // can be null specifically for new user using invite form
    @Column(columnDefinition = "integer default 10")
    private long phone;

    // can be null specifically for new user using invite form
    // does not need to be unique
    @Column(length = 255)
    private String streetAddress;

    // can be null specifically for new user using invite form
    // does not need to be unique
    @Column(length = 255)
    private String city;

    // can be null specifically for new user using invite form
    // does not need to be unique
    @Column(length = 255)
    private String state;

    // can be null specifically for new user using invite form
    @Column(columnDefinition = "integer default 9")
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

    public User(User copy) {
        id = copy.id; //
        email = copy.email;
        username = copy.username;
        password = copy.password;
    }


    //Empty constructor - do not delete/edit
    public User() {
    }

}