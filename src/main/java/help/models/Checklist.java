package help.models;

import javax.persistence.*;

@Entity
@Table(name = "checklists")
public class Checklist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 255)
    private String title;

    //Empty constructor - do not delete/edit
    public Checklist(){}

}