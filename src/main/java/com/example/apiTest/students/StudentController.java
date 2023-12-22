package com.example.apiTest.students;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RequestMapping("v1/students")
@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "list")
    public List<Student> list() throws ExecutionException, InterruptedException {
        return studentService.list();
    }

    @PostMapping (path = "item")
    public String add(@RequestBody Student student) throws ExecutionException, InterruptedException {
        return studentService.add(student);

    }
}
