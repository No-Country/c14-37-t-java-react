package com.nocountryc14.listacheck.service.implementation;

import com.nocountryc14.listacheck.model.Note;
import com.nocountryc14.listacheck.repository.INoteRepository;
import com.nocountryc14.listacheck.service.INoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteServiceImpl implements INoteService {


    private INoteRepository noteRepository;

   
    @Autowired
    public NoteServiceImpl(INoteRepository noteRepository) {
        this.noteRepository = noteRepository;
      
    }
    // This method is used to create a note.
    @Override
    public Note createNote(Note note) {

        Note savedNote = noteRepository.save(note);
        return savedNote;
    }

    // This method is used to get a list with all the notes.
    @Override
    public List<Note> getNotes() {
        List<Note> notes = noteRepository.findAll();
        return notes;
    }

    // This method is used to delete a note by ID.
    @Override
    public void deleteNote(Long id_note) {
        noteRepository.deleteById(id_note);
    }

    // This method is used to find a note by ID.
    @Override
    public Note findNoteById(Long id_note) {
        Note note = noteRepository.findById(id_note).orElse(null);
        return note;
    }

    // This method is used to update a note by ID.
    @Override
    public Note updateNote(Long id_note, Note updatedNote) {
        Note existingNote = noteRepository.findById(id_note).orElse(null);

        if (existingNote != null) {
            existingNote.setNoteField(updatedNote.getNoteField());
            Note savedNote = noteRepository.save(existingNote);
            return savedNote;
        } else {
            return null;
        }
    }
    
}
