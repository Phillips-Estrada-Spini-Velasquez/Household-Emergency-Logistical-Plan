package help.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 255)
    private String name;

    //temp, might need to change
    @Column
    private String rallyPointCoordinates;

    //One to Many because one group x many users
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    private List<User> users;




    //Empty constructor - do not delete/edit
    public Group(){}
}
