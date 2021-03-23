package com.anas.demo.student;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Student {
  @Id
  @SequenceGenerator(
          name="student_sequence",
          sequenceName="student_sequence",
          allocationSize=1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "student_sequence"
  )
  private Long id;
  private String name;
  private int age;
  private LocalDate dob;
  private String email;

  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LocalDate getDob() {
    return dob;
  }

  public void setDob(LocalDate dob) {
    this.dob = dob;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public Student(Long id, String name, int age, LocalDate dob, String email) {
    this.id = id;
    this.setName(name);
    this.setAge(age);
    this.setDob(dob);
    this.setEmail(email);
  }

  public Student(String name, int age, LocalDate dob, String email) {
    this.setName(name);
    this.setAge(age);
    this.setDob(dob);
    this.setEmail(email);
  }

  @Override
  public String toString() {
    return "Student [age=" + age + ", dob=" + dob + ", email=" + email + ", id=" + id + ", name=" + name + "]";
  }

}
