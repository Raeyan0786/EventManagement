package com.example.EventManagement.controller;

import com.example.EventManagement.model.Student;
import com.example.EventManagement.service.StudentService;
import com.example.EventManagement.utils.UserValidator;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
    public ResponseEntity<String> add_student(@RequestBody String student){
        JSONObject jsonObject=new JSONObject(student);

        List<String> valid= UserValidator.isValidUser(jsonObject);
        if(valid.isEmpty()){
            Student newUser=studentService.setStudent(jsonObject);
            studentService.addStudent(newUser);
            return new ResponseEntity<>("user saved", HttpStatus.CREATED);
        }
        String[] answer = Arrays.copyOf(
                valid.toArray(), valid.size(), String[].class);

        return new ResponseEntity<>("Please pass these mandatory parameters- " +
                Arrays.toString(answer), HttpStatus.BAD_REQUEST);

    }
    @PutMapping("update-student/by/id/{id}")
    public ResponseEntity<String> update_student(@PathVariable int id,@RequestBody String student){
        JSONObject jsonObject=new JSONObject(student);

        List<String> valid= UserValidator.isValidUser(jsonObject);
        if(valid.isEmpty()){
            Student newUser=studentService.setStudent(jsonObject);
            studentService.addStudent(newUser);
            return new ResponseEntity<>("user updated", HttpStatus.OK);
        }
        String[] answer = Arrays.copyOf(
                valid.toArray(), valid.size(), String[].class);

        return new ResponseEntity<>("Please pass these mandatory parameters- " +
                Arrays.toString(answer), HttpStatus.BAD_REQUEST);

    }
    @DeleteMapping("/delete-student/by/id/{id}")
    public void delete_student(@PathVariable int id){
        studentService.deleteStudent(id);
    }

}
