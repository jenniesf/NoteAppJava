package com.devmountain.noteApp.services;

import com.devmountain.noteApp.dtos.NoteDto;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface NoteService {
    // ADD A NOTE FOR A USER
    @Transactional
    void addNote(NoteDto noteDto, Long userId);

    // DELETE A NOTE BY NOTE ID
    @Transactional
    void deleteNoteById(Long noteId);

    // UPDATE A NOTE BY GETTING NOTE ID
    @Transactional
    void updateNoteById(NoteDto noteDto);

    // FIND ALL NOTES FOR A USER
    List<NoteDto> getAllNotesByUserId(Long userId);

    // GET A NOTE BY NOTE ID
    Optional<NoteDto> getNoteById(Long noteId);
}
