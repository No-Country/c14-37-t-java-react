package com.nocountryc14.listacheck.service.implementation;

import com.nocountryc14.listacheck.dto.NoteDto;
import com.nocountryc14.listacheck.mapper.NoteMapper;
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

    private NoteMapper noteMapper;
    @Autowired
    public NoteServiceImpl(INoteRepository noteRepository, NoteMapper noteMapper) {
        this.noteRepository = noteRepository;
        this.noteMapper = noteMapper;
    }
    // This method is used to create a note.
    @Override
    public NoteDto createNote(NoteDto notesDto) {
        Note note  = noteMapper.toNote(notesDto);
        Note savedNote = noteRepository.save(note);
        return noteMapper.toDto(savedNote);
    }

    // This method is used to get a list with all the notes.
    @Override
    public List<NoteDto> getNotes() {
        List<Note> notes = noteRepository.findAll();
        return notes.stream().map(noteMapper::toDto).collect(Collectors.toList());
    }

    // This method is used to delete a note by ID.
    @Override
    public void deleteNote(Long id_note) {
        noteRepository.deleteById(id_note);
    }

    // This method is used to find a note by ID.
    @Override
    public NoteDto findNoteById(Long id_note) {
        Note note = noteRepository.findById(id_note).orElse(null);
        return (note != null) ? noteMapper.toDto(note) : null;
    }

    // This method is used to update a note by ID.
    @Override
    public NoteDto updateNote(Long id_note, NoteDto updatedNoteDto) {
        Note existingNote = noteRepository.findById(id_note).orElse(null);

        if (existingNote != null) {
            existingNote.setNoteField(updatedNoteDto.getNoteField());
            Note savedNote = noteRepository.save(existingNote);
            return noteMapper.toDto(savedNote);
        } else {
            return null;
        }
    }
    
}
