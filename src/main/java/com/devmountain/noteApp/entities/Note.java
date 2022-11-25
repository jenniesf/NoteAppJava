package com.devmountain.noteApp.entities;

import com.devmountain.noteApp.dtos.NoteDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// @Entity - this is annotation is what tells Spring that this class is being mapped to a data source
// @Table - this is where you can set what table you want these objects to be mapped to
// @Data, @AllArgsConstructor and @NoArgsConstructor - dependency is called Lombok and looks at the member
        // variables and can generate all of our getters and setters for us,
        // as well as the constructors all through 3 annotations. No need to create
        // empty and full constructors with these wo

@Entity
@Table(name = "Notes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Note {

    // FIELDS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "text")
    private String body;
    // create User object (from User entity)
        // User can have many notes and many notes can be owed by a user - One to many; many to one
    @ManyToOne
    @JsonBackReference  // prevents infinite recursion when you deliver the resource up as JSON through the REST API endpoint you will create
    private User user;


    // remove constructors since using Lombok annotations
                // EMPTY CONSTRUCTOR
            //    public Note() {
            //    }
                // CONSTRUCTOR
            //    public Note(Long id, String body) {
            //        this.id = id;
            //        this.body = body;
            //    }

    // CONSTRUCTOR FOR DTO
    // custom constructor inside the Entity that accepts a DTO argument.
        // Note that on the Entity side, we do not need to define the “id” member
        // variable when constructing a new object as that value is being generated
        // for us by Hibernate’s @Id and @GeneratedValue annotations.
        // Note’s “user” field cannot be defined from the DTO, so it is not necessary
        // to define either field in the constructor, those fields will be populated in the Service layer
    public Note (NoteDto noteDto) {
        if (noteDto.getBody() != null ) {
            this.body = noteDto.getBody();
        }
    }

    // GETTERS AND SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
