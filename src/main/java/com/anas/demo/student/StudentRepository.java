package com.anas.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// Long est le type de l'id d'un student
public interface StudentRepository extends JpaRepository<Student, Long> {
}
