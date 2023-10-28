package com.nocountryc14.listacheck.service;

import com.nocountryc14.listacheck.model.Note;

import java.util.List;

public interface INoteService {

    Note createNote(Note note);

    List<Note> getNotes();

    void deleteNote(Long id_note);

    Note findNoteById(Long id_note);

    Note updateNote(Long id_note, Note updatedNote);


}
