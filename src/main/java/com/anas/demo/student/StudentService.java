package com.anas.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// l'annotatioin Service indique que notre class est un bean
// instanciable par exemple par le biais dautowire
@Service
public class StudentService {

  private final StudentRepository studentRepository;

  @Autowired
  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public List<Student> getStudent() {
    return studentRepository.findAll();
  }

  public void addNewStudent(Student student) {
    Optional<Student> studentOptinal = studentRepository.findStudentByEmail(student.getEmail());
    if (studentOptinal.isPresent()) {
      throw new IllegalStateException("email taken");
    }
    studentRepository.save(student);
    System.out.println(student);
  }

  public void deleteStudent(Long studentId) {
    boolean exists = studentRepository.existsById(studentId);
    if (!exists) {
      throw new IllegalStateException("student with id " + studentId + " does not exist");
    }
    studentRepository.deleteById(studentId);
  }
}
