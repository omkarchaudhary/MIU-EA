package com.miu.firstspringdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
public class StudentController {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private ResourceBundleMessageSource resourceBundleMessageSource;

    @GetMapping
    public String  byDefault(){
        return "please correct url";
    }

    @GetMapping(path = "/hello")
//    private String getHello(@RequestHeader(name = "Accept-Language", required = false) Locale locale){
//        return resourceBundleMessageSource.getMessage("good.morning.message", null, locale);
//    }
    private String getHello(){
        return resourceBundleMessageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
    }

    @GetMapping(path = "hello/{name}")
    private String getHello(@PathVariable String name){
        return "Hi Folks "+ name;
    }

    @GetMapping(path = "/students")
    public List<Student> getStudentList(){
        return studentRepo.getStudentList();
    }
    @PostMapping(path = "/addStudent")
    public void addStudent(@RequestBody Student student){
        studentRepo.addStudent(student);
    }
    @GetMapping(path = "/student/{id}")
    public Student getStudent(@PathVariable int id){
       return studentRepo.getStudent(id);
    }
}
