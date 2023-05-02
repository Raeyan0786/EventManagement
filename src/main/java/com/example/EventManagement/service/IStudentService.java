package com.example.EventManagement.service;

import com.example.EventManagement.model.Student;

import java.util.List;

public interface IStudentService {
    void addStudent(Student student);
    void updateStudent(int id, Student newstudent);
    List<Student> getAll();
    Student getById(int id);
    void deleteStudent(int id);

}
