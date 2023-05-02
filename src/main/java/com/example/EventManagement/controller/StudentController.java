package com.example.EventManagement.controller;

import com.example.EventManagement.model.Student;
import com.example.EventManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("management-app/v1")
public class StudentController {
    @Autowired
    StudentService studentService;
    @GetMapping("/get-all/student")
    public List<Student> get_all(){
        return studentService.getAll();
    }
    @GetMapping("/get-student/by/id/{id}")
    public Student get_by_id(@PathVariable int id){
        return  studentService.getById(id);
    }
    @PostMapping("/add-student")
    public void add_student(@RequestBody Student student){
        studentService.addStudent(student);
    }
    @PutMapping("update-student/by/id/{id}")
    public void update_student(@PathVariable int id,@RequestBody Student student){
        studentService.updateStudent(id,student);
    }
    @DeleteMapping("/delete-student/by/id/{id}")
    public void delete_student(@PathVariable int id){
        studentService.deleteStudent(id);
    }

}
