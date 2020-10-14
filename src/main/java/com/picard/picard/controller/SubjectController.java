package com.picard.picard.controller;

import com.picard.picard.domian.Subject;
import com.picard.picard.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SubjectController {
    @GetMapping("/")
    public String subject_home() {
        return "subject_home";
    }

    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/subjects/new")
    public String subjectInfo() {
        return "subjects/subjectInfo";
    }

    @PostMapping("subjects/new")
    public String create(SubjectForm form) {
        Subject subject = new Subject();
        subject.setAge(form.getAge());
        subject.setSex(form.getSex());
        subject.setDiagnosis(form.getDiagnosis());
        subject.setTumorStage(form.getTumorStage());
        subject.setRecurrence(form.getRecurrence());
        subject.setMetastasis(form.getMetastasis());
        subject.setLocation(form.getLocation());
        subject.setEntrostomy(form.getEntrostomy());
        subject.setOperation(form.getOperation());
        subject.setOperationDate(form.getOperationDate());
        subject.setSurgery(form.getSurgery());
        subject.setAnticancer(form.getAnticancer());
        subject.setAnticancerDate(form.getAnticancerDate());
        subject.setRadiationTreatment(form.getRadiationTreatment());
        subject.setRadiationTreatmentDate(form.getRadiationTreatmentDate());

        System.out.println("subject = " + subject.getAge());
        System.out.println("subject = " + subject.getId());
        subjectService.join(subject);

        return "redirect:/";
    }

    @GetMapping("/subjects")
    public String list(Model model) {
        List<Subject> subjects = subjectService.findSubjects();
        model.addAttribute("subjects", subjects);
        return "subjects/print";
    }

    @GetMapping("subjects/iframe")
    public String print_iframe() {

        return "subjects/iframe";
    }

}
