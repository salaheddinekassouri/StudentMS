package com.example.StudentMS.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentMS.model.Student;
import com.example.StudentMS.model.University;
import com.example.StudentMS.repository.UniversityRepository;
import com.example.StudentMS.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return service.addStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
    }

    // 🔍 Search by ID
    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id) {
        return service.getStudentById(id);
    }

    // 🔍 Search by Name
    @GetMapping("/search/byName")
    public List<Student> getStudentsByName(@RequestParam String name) {
        return service.getStudentsByName(name);
    }

    // 🔍 Search by Department
    @GetMapping("/search/byDepartment")
    public List<Student> getStudentsByDepartment(@RequestParam String department) {
        return service.getStudentsByDepartment(department);
    }
    // 🔍 Search by University
    @GetMapping("/search/byUniversity")
    public List<Student> getStudentsByUniversity(@RequestParam String university) {
        return service.getStudentsByUniversity(university);
    }

     @Autowired
    private UniversityRepository universityRepository;

    // Existing StudentRepository and Student endpoints here

    // ==============================
    // Create a new University
    // ==============================
    @PostMapping("/universities")
    public University createUniversity(@RequestBody University university) {
        return universityRepository.save(university);
    }

    // ==============================
    // Get all Universities
    // ==============================
    @GetMapping("/universities")
    public List<University> getAllUniversities() {
        return universityRepository.findAll();
    }


    @GetMapping("/search")
public Object searchStudents(
        @RequestParam(required = false) Long id,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String department) {

    if (id != null) return service.getStudentById(id);
    if (name != null) return service.getStudentsByName(name);
    if (department != null) return service.getStudentsByDepartment(department);
    return service.getAllStudents();
}
}   