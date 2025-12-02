package com.example.StudentMS.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StudentMS.model.Student;
import com.example.StudentMS.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public Student addStudent(Student student) {
        return repository.save(student);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }

    // 🔍 Search by ID
    public Optional<Student> getStudentById(Long id) {
        return repository.findById(id);
    }

    // 🔍 Search by Name
    public List<Student> getStudentsByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    // 🔍 Search by Email
    public List<Student> getStudentsByEmail(String email) {
        return repository.findByEmailContainingIgnoreCase(email);
    }
    // 🔍 Search by University
    public List<Student> getStudentsByUniversity(String university) {
        return repository.findByUniversityContainingIgnoreCase(university);
    }
    }