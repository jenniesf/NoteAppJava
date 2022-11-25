package com.devmountain.noteApp.services;

import com.devmountain.noteApp.dtos.NoteDto;
import com.devmountain.noteApp.entities.Note;
import com.devmountain.noteApp.entities.User;
import com.devmountain.noteApp.repositories.NoteRepository;
import com.devmountain.noteApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// Service Layer is where the business logic resides.
    // This is the brains of the operation lives here. This is the
    // layer where you are receiving information from the Repository Layer,
    // performing any necessary transformations and then passing them
    // on to the Controller to handle the request.

// Things to do: find all notes by User, add, delete, update a note, find note by an id

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private UserRepository userRepository;
    @Autowired  // Spring is able to find the corresponding dependency and inject it
    private NoteRepository noteRepository;

    // ADD A NOTE FOR A USER
    @Override
    @Transactional
    public void addNote(NoteDto noteDto, Long userId) {
        Optional<User> userOptional = userRepository.findById( userId );  // find user id
        Note note = new Note(noteDto); // create new note
        userOptional.ifPresent( note::setUser); // if user found, set note to user
        noteRepository.saveAndFlush(note);      // save; to persist the action
    }
    // DELETE A NOTE BY NOTE ID
    @Override
    @Transactional
    public void deleteNoteById(Long noteId) {
        Optional<Note> noteOptional = noteRepository.findById( noteId );
        noteOptional.ifPresent( note -> noteRepository.delete(note));
    }
    // UPDATE A NOTE BY GETTING NOTE ID
    @Override
    @Transactional
    public void updateNoteById(NoteDto noteDto) {
        Optional<Note> noteOptional = noteRepository.findById( noteDto.getId() );
        noteOptional.ifPresent( note -> {
            note.setBody( noteDto.getBody() );
            noteRepository.saveAndFlush( note );
        });
    }
    // FIND ALL NOTES FOR A USER
    @Override
    public List<NoteDto> getAllNotesByUserId(Long userId) {
        Optional<User> userOptional = userRepository.findById( userId );
        if ( userOptional.isPresent() ) {
          List<Note> noteList = noteRepository.findAllByUserEquals( userOptional.get() );
          return noteList.stream().map( note -> new NoteDto( note )).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
    // GET A NOTE BY NOTE ID
    @Override
    public Optional<NoteDto> getNoteById(Long noteId) {
        Optional<Note> noteOptional = noteRepository.findById( noteId );
        if ( noteOptional.isPresent() ) {
            return Optional.of(new NoteDto( noteOptional.get() ));
        }
        return Optional.empty();
    }
}


