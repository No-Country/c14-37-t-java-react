package com.nocountryc14.listacheck.controller;

import com.nocountryc14.listacheck.model.Note;
import com.nocountryc14.listacheck.service.INoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private INoteService noteService;

    // Create
    @PostMapping("/create")
    public ResponseEntity<Note> createNote(@RequestBody Note note) throws RuntimeException{
        if (note.getNoteField() == null) {
            throw new RuntimeException("Note must have a field");
        }
        //noteService.createNote(note);
        return new ResponseEntity<>(noteService.createNote(note), HttpStatus.CREATED);
    }

    // Get
    @GetMapping("/get")
    public ResponseEntity<List<Note>> getNotes() {
        List<Note> notes = noteService.getNotes();
        if (notes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(notes, HttpStatus.OK);
        }
    }

    // Delete
    @DeleteMapping("/delete/{id_note}")
    public ResponseEntity<Note> deleteNote(@PathVariable Long id_note) {
        Note note = noteService.findNoteById(id_note);
        if (note != null) {
            noteService.deleteNote(id_note);
            return new ResponseEntity<>(note, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Find by ID
    @GetMapping("/{id_note}")
    public ResponseEntity<Note> findNoteById(@PathVariable Long id_note) {
        Note note = noteService.findNoteById(id_note);
        if (note != null) {
            return new ResponseEntity<>(note, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update
    @PutMapping("/update/{id_note}")
    public ResponseEntity<Note> updateNote (@PathVariable Long id_note, @RequestBody Note updatedNote) {
        Note note = noteService.updateNote(id_note, updatedNote);
        if (note != null) {
            return new ResponseEntity<>(note, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}