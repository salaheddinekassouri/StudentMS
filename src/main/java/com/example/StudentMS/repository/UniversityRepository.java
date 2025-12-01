package com.example.StudentMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.StudentMS.model.University;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {
}
