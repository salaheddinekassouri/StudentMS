package com.example.StudentMS.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "STUDENTS")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    // Many students belong to one university
    @ManyToOne(optional = true)
    @JoinColumn(name = "university_id")
    private University university;

    // Constructors
    public Student() {}

    public Student(String name, String email, University university) {
        this.name = name;
        this.email = email;
        this.university = university;
    }

    // Getters & setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public University getUniversity() { return university; }

    public void setUniversity(University university) { this.university = university; }
}
