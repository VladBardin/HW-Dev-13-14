package main.SpringBoot;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class NoteService {
    private final NoteRepository noteRepository;
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }
    public List<Note> listAll() {
        return noteRepository.findAll();
    }
    public Note add(Note note) {
        return noteRepository.save(note);
    }
    public void deleteById(long id) {
        if (!noteRepository.existsById(id)) {
            throw new IllegalArgumentException("Note with id " + id + " not found.");
        }
        noteRepository.deleteById(id);
    }
    public void update(Note note) {
        if (!noteRepository.existsById(note.getId())) {
            throw new IllegalArgumentException("Note with id " + note.getId() + " not found.");
        }
        noteRepository.save(note);
    }
    public Note getById(long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Note with id " + id + " not found."));
    }
}
