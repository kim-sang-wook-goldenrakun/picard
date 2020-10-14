package com.picard.picard.repository;

import com.picard.picard.domian.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectRepository {
    Subject save(Subject member);
    Optional<Subject> findById(Long id);
    Optional<Subject> findByAge(String age);
    List<Subject> findAll();
}
