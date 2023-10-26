package com.nocountryc14.listacheck.service;

import com.nocountryc14.listacheck.dto.NoteDto;

import java.util.List;

public interface INoteService {

    NoteDto createNote(NoteDto noteDto);

    List<NoteDto> getNotes();

    void deleteNote(Long id_note);

    NoteDto findNoteById(Long id_note);

    NoteDto updateNote(Long id_note, NoteDto updatedNoteDto);


}
