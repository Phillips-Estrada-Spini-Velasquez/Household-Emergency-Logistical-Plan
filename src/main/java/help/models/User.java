package help.models;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 255, unique = true)
    private String firstName;

    @Column(nullable = false, length = 255, unique = true)
    private String lastName;

    @Column(nullable = false, length = 255, unique = true)
    private String username;

    @Column(nullable = false, length = 255, unique = true)
    private String email;

    @Column(nullable = false, length = 255, unique = true)
    private String password;

    @Column(nullable = false, columnDefinition = "integer default 10")
    private long phone;

    @Column(nullable = false, length = 255, unique = true)
    private String streetAddress;

    @Column(nullable = false, length = 255, unique = true)
    private String city;

    @Column(nullable = false, length = 255, unique = true)
    private String state;

    @Column(nullable = false, columnDefinition = "integer default 9")
    private long zip;

    //Many to Many because many users x one group - casey suggested many to many but it makes me want to cry - lets discuss
    @ManyToOne
    @JoinColumn (name = "group_id")
    private Group group;


    //Empty constructor - do not delete/edit
    public User() {
    }

}