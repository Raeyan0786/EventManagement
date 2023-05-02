package com.example.EventManagement.service;

import com.example.EventManagement.model.Student;
import com.example.EventManagement.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    IStudentRepository iStudentRepository;
    @Override
    public void addStudent(Student student) {
        iStudentRepository.save(student);
    }

    @Override
    public Student getById(int id) {
        return iStudentRepository.findById(id).get();
    }

    @Override
    public List<Student> getAll() {
        return iStudentRepository.findAll();
    }

    @Override
    public void deleteStudent(int id) {
        iStudentRepository.deleteById(id);
    }

    @Override
    public void updateStudent(int id, Student newstudent) {
        Student student=getById(id);
        student.setStudentId(newstudent.getStudentId());
        student.setDepartment(newstudent.getDepartment());
        student.setFirst_name(newstudent.getFirst_name());
        student.setLast_name(newstudent.getLast_name());
        iStudentRepository.save(student);
    }
}
