package com.picard.picard;

import com.picard.picard.domian.Subject;
import com.picard.picard.repository.MemberRepository;
import com.picard.picard.repository.MemoryMemberRepository;
import com.picard.picard.repository.MemorySubjectRepository;
import com.picard.picard.repository.SubjectRepository;
import com.picard.picard.service.MemberService;
import com.picard.picard.service.SubjectService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public SubjectService subjectService() {
        return new SubjectService(subjectRepository());
    }

    @Bean
    public SubjectRepository subjectRepository() {
        return new MemorySubjectRepository();
    }

}
