package help.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

//    //only one admin can be the owner - nothing needed on the other one
//    @OneToOne
//    @JoinColumn(name = "owner_id")
//    private User owner;

    //One to Many because one group x many users
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    @JsonIgnore
    private List<User> users;

    // One to Many because one group x many messages
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    @JsonIgnore
    private List<Message> messages;

    //One to Many because one group x many documents
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    private List<Document> documents;

    //One to Many because one group x many items
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    @JsonIgnore
    private List<Item> items;


    //Empty constructor - do not delete/edit
    public Group() {
    }

    public Group(long id, String name, String rallyPointCoordinates, List<User> users, List<Message> messages, List<Document> documents, List<Item> items) {
        this.id = id;
        this.name = name;
        this.rallyPointCoordinates = rallyPointCoordinates;
        this.users = users;
        this.messages = messages;
        this.documents = documents;
        this.items = items;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRallyPointCoordinates() {
        return rallyPointCoordinates;
    }

    public void setRallyPointCoordinates(String rallyPointCoordinates) {
        this.rallyPointCoordinates = rallyPointCoordinates;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}