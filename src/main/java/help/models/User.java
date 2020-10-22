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

    public User(long id, String firstName, String lastName, String username, String email, String password, long phone, String streetAddress, String city, String state, long zip, List<Group> groups) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.groups = groups;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getZip() {
        return zip;
    }

    public void setZip(long zip) {
        this.zip = zip;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}