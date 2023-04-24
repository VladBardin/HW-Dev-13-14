package config;

import main.SpringBoot.controller.NoteController;
import main.SpringBoot.controller.TestController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {
   @Bean
    public TestController myController() {
        return new TestController();
    }
   @Bean
    public NoteController noteController() {
        return new NoteController();
    }
}
