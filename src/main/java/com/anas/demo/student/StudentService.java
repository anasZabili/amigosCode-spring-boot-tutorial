package com.anas.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.springframework.stereotype.Service;

// l'annotatioin Service indique que notre class est un bean
// instanciable par exemple par le biais dautowire
@Service
public class StudentService {
  public List<Student> getStudent() {
    return List.of(new Student(1L, "John", 5, LocalDate.of(2000, Month.AUGUST, 5), "john@john.com"));
  }

}
