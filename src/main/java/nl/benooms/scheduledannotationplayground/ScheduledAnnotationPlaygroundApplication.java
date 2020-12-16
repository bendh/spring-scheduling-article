package nl.benooms.scheduledannotationplayground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ScheduledAnnotationPlaygroundApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduledAnnotationPlaygroundApplication.class, args);
    }

}
