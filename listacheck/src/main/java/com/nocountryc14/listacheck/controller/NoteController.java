package com.nocountryc14.listacheck.controller;

import com.nocountryc14.listacheck.dto.NoteDto;
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
    public ResponseEntity<NoteDto> createNote(@RequestBody NoteDto noteDto) throws RuntimeException{
        if (noteDto.getNoteField() == null) {
            throw new RuntimeException("Note must have a field");
        }
        //noteService.createNote(noteDto);
        return new ResponseEntity<>(noteService.createNote(noteDto), HttpStatus.CREATED);
    }

    // Get
    @GetMapping("/get")
    public ResponseEntity<List<NoteDto>> getNotes() {
        List<NoteDto> notesDto = noteService.getNotes();
        if (notesDto.isEmpty()) {
            return new ResponseEntity<>(notesDto, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    // Delete
    @DeleteMapping("/delete/{id_note}")
    public ResponseEntity<NoteDto> deleteNote(@PathVariable Long id_note) {
        NoteDto noteDto = noteService.findNoteById(id_note);
        if (noteDto != null) {
            noteService.deleteNote(id_note);
            return new ResponseEntity<>(noteDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Find by ID
    @GetMapping("/{id_note}")
    public ResponseEntity<NoteDto> findNoteById(@PathVariable Long id_note) {
        NoteDto noteDto = noteService.findNoteById(id_note);
        if (noteDto != null) {
            return new ResponseEntity<>(noteDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update
    @PutMapping("/update/{id_note}")
    public ResponseEntity<NoteDto> updateNote (@PathVariable Long id_note, @RequestBody NoteDto updatedNoteDto) {
        NoteDto noteDto = noteService.updateNote(id_note, updatedNoteDto);
        if (noteDto != null) {
            return new ResponseEntity<>(noteDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}