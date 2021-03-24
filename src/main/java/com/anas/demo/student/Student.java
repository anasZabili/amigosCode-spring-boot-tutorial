package com.anas.demo.student;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

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
  // transient specifie que le champs age
  // ne dois pas etre une colone dans la database
  // il va etre calculé, ainsi cette info n'apparait pas dans la bdd
  // mais sera retourné par notre api
  @Transient
  private int age;
  private LocalDate dob;
  private String email;

  public Student() {
    super();
  }

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
    return Period.between(this.dob, LocalDate.now()).getYears();
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


  public Student(Long id, String name, LocalDate dob, String email) {
    this.id = id;
    this.setName(name);
    this.setDob(dob);
    this.setEmail(email);
  }

  public Student(String name, LocalDate dob, String email) {
    this.setName(name);
    this.setDob(dob);
    this.setEmail(email);
  }

  @Override
  public String toString() {
    return "Student [age=" + age + ", dob=" + dob + ", email=" + email + ", id=" + id + ", name=" + name + "]";
  }

}
