package com.anas.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;



// cette class est excuter avant les autre pour set notre bdd avec
// des valeurs par default
@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student stud1 = new Student(
                    "John",
                    LocalDate.of(2000, Month.AUGUST, 5),
                    "john@john.com"
            );
            Student stud2 = new Student(
                    "Didier",
                    LocalDate.of(2001, Month.AUGUST, 5),
                    "didier@didier.com"
            );
            repository.saveAll(
                    List.of(stud1, stud2)
            );
        };
    }
}
