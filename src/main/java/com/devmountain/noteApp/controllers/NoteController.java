package com.devmountain.noteApp.controllers;

// CONTROLLERS - define REST API endpoints and creating
// the paths that can deliver up the information to the client

import com.devmountain.noteApp.dtos.NoteDto;
import com.devmountain.noteApp.entities.Note;
import com.devmountain.noteApp.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    // GET ALL NOTES BY USER ID
    @GetMapping("/user/{userId}")
    public List<NoteDto> getNotesByUser(@PathVariable Long userId ) {
        return noteService.getAllNotesByUserId(userId);
    }

    // POST A NOTE FOR A USER ID
    @PostMapping("/user/{userId}")
    public void addNote(@RequestBody NoteDto noteDto, @PathVariable Long userId) {
        noteService.addNote( noteDto , userId);
    }

    // DELETE NOTE BY ID
    @DeleteMapping("/{noteId}")
    public void deleteNoteById(@PathVariable Long noteId) {
        noteService.deleteNoteById(noteId);
    }

    // PUT - UPDATE NOTE BY ID
    @PutMapping
    public void updateNote( @RequestBody NoteDto noteDto ) {
        noteService.updateNoteById( noteDto );
    }

    // GET A NOTE BY ID
    @GetMapping("/{noteId}")
    public Optional<NoteDto> getNoteById( @PathVariable Long noteId) {
        return noteService.getNoteById( noteId );
    }
}
