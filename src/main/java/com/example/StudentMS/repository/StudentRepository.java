package com.example.StudentMS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.StudentMS.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // 🔍 Search by name (case-insensitive)
    @Query("SELECT s FROM Student s WHERE LOWER(s.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Student> findByNameContainingIgnoreCase(@Param("name") String name);

    // 🔍 Search by department (case-insensitive)
    @Query("SELECT s FROM Student s WHERE LOWER(s.department) LIKE LOWER(CONCAT('%', :department, '%'))")
    List<Student> findByDepartmentContainingIgnoreCase(@Param("department") String department);

    // 🔍 Search by university (case-insensitive)
    @Query("SELECT s FROM Student s WHERE LOWER(s.university) LIKE LOWER(CONCAT('%', :university, '%'))")
    List<Student> findByUniversityContainingIgnoreCase(@Param("university") String university);
}
    