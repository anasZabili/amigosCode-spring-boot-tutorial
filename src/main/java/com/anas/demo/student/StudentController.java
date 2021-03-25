package com.anas.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
// request mapping ici permet de cette la route de notre api
@RequestMapping("api/v1/student")
public class StudentController {

  private final StudentService studentService;

  @GetMapping("/")
  public List<Student> getStudent() {
    return studentService.getStudent();
  }
  
  @Autowired
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }
  
  @PostMapping
  public void registerNewStudent(@RequestBody Student student) {
    this.studentService.addNewStudent(student);
  }

  @DeleteMapping(path = "{studentId}")
  public void DeleteStudent(@PathVariable ("studentId") Long studentId) {
    this.studentService.deleteStudent(studentId);
  }

}
