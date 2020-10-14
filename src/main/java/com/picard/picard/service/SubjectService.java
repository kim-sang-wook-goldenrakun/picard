package com.picard.picard.service;

import com.picard.picard.domian.Member;
import com.picard.picard.domian.Subject;
import com.picard.picard.repository.MemberRepository;
import com.picard.picard.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class SubjectService {

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public Long join(Subject subject) {

        validateDuplicateSubject(subject); // 중복회원 검증
        subjectRepository.save(subject);
        return subject.getId();
    }

    private void validateDuplicateSubject(Subject subject) {
        subjectRepository.findByAge(subject.getAge())
                .ifPresent(m-> {
                    throw new IllegalStateException("이미 존재하는 회원 입니다");
                });
    }

    public List<Subject> findSubjects() {
        return subjectRepository.findAll();
    }

    public Optional<Subject> findOne(Long subjectId) {
        return subjectRepository.findById(subjectId);
    }
}
