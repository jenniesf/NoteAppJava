package com.devmountain.noteApp.entities;

import com.devmountain.noteApp.dtos.UserDto;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

// @Entity - this is annotation is what tells Spring that this class is being mapped to a data source
// @Table - this is where you can set what table you want these objects to be mapped to
@Entity
@Table(name="Users")
public class User {
    // FIELDS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    @Column
    private String password;
    // User can have many notes and many notes can be owed by a user - One to many; many to one
        // use of a Java Data Structure called a Set to act as the container for our Notes.
        // The reason we chose a Set is because each item within a Set is unique.
        // This does not mean that the “body” Strings can’t be duplicated, you could have
        // two Notes that say the same thing. What the Set does though is prevent two copies
        // of the Note Object from being added in and taking up excess space in your application.
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference  // mitigate infinite recursion
    private Set<Note> noteSet = new HashSet<>();


    // EMPTY CONSTRUCTOR
    public User() {
    }

    // CONSTRUCTOR
    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    // CONSTRUCTOR FOR DTO
        // custom constructor inside the Entity that accepts a DTO argument.
        // Note that on the Entity side, we do not need to define the “id” member
        // variable when constructing a new object as that value is being generated
        // for us by Hibernate’s @Id and @GeneratedValue annotations.
        // Note that User’s “noteSet” field is already being initialized to a “new HashSet<>()”
    public User (UserDto userDto) {
        if( userDto.getUsername() != null ) {
            this.username = userDto.getUsername();
        }
        if ( userDto.getPassword() != null ) {
            this.password = userDto.getPassword();
        }
    }


    // GETTER AND SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
