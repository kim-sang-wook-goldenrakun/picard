package com.picard.picard.repository;

import com.picard.picard.domian.Subject;

import java.util.*;

public class MemorySubjectRepository implements SubjectRepository {
    private static Map<Long, Subject> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Subject save(Subject subject) {
        subject.setId(++sequence);
        store.put(subject.getId(), subject);

        return subject;
    }

    @Override
    public Optional<Subject> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Subject> findByAge(String age) {
        return  store.values().stream()
                .filter(subject -> subject.getAge().equals(age))
                .findAny();
    }

    @Override
    public List<Subject> findAll() {
        return new ArrayList<>(store.values());
    }
}
