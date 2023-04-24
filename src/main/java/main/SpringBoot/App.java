package main.SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class App implements CommandLineRunner {
    @Autowired
    private NoteService noteService;

    public static void main(String[] args) {
        new DataInit().initDb();
        try (ConfigurableApplicationContext context = SpringApplication.run(App.class, args)) {
            Thread.sleep(200000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

@Override
public void run(String...args){
        for(int i=0;i< 5;i++){
        Note newNote=new Note();
        newNote.setTitle("New note");
        newNote.setContent("This is the content of the new note");
        noteService.add(newNote);
        }
        noteService.deleteById(2);
        System.out.println("All notes:");
        List<Note> notes=noteService.listAll();
        for(Note note:notes){
        System.out.println(note);
        }
        Note newNote=new Note();
        newNote.setTitle("My last note");
        newNote.setContent("This is the content of the new note ");
        noteService.add(newNote);
        newNote.setContent("Changes");
        noteService.update(newNote);
        System.out.println("new "+noteService.getById(6));
        }
}