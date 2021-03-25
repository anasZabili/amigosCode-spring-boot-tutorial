package com.anas.demo.student;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
// Long est le type de l'id d'un student
public interface StudentRepository extends JpaRepository<Student, Long> {
    // SELECT * FROM student where email = ?
    // on est capable decrire cette requete car on a annoté la class student avec entity
    // ce qui indique que student est une table qui peut donc etre explicité dans nos requete
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}
