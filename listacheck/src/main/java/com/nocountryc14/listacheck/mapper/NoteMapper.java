package com.nocountryc14.listacheck.mapper;

import com.nocountryc14.listacheck.dto.NoteDto;
import com.nocountryc14.listacheck.model.Note;
import org.springframework.stereotype.Component;

@Component

public class NoteMapper {

    public NoteDto toDto(Note note){
        NoteDto noteDto = new NoteDto();
        if(note.getNoteId() != null){
            noteDto.setNoteId(note.getNoteId());
        }
        noteDto.setNoteField(note.getNoteField());
        return noteDto;
    }
    public Note toNote(NoteDto noteDto){
        Note note = new Note();
        if(noteDto.getNoteId() != null){
            note.setNoteId(noteDto.getNoteId());
        }
        System.out.println(noteDto.getNoteField());
        note.setNoteField(noteDto.getNoteField());
        return note;
    }
}