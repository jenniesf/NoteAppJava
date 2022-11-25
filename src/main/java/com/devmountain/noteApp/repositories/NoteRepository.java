package com.devmountain.noteApp.repositories;

import com.devmountain.noteApp.entities.Note;
import com.devmountain.noteApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// The Repository Layer only interacts with the Service Layer and the Entities.
    // and is responsible for interacting with the database
    // We can use Spring Data JPA however to make this process a
    // little easier as well as increase developer agility by leveraging
    // the Domain Specific Language provided by Spring Data JPA


@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    // JPA will implement the actual SQL logic to be able to query
        // the database and search the Users table for the User with a
        // username that equals the string we gave it
    List<Note> findAllByUserEquals ( User user );
}
