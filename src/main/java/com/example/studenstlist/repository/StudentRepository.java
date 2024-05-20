package com.example.studenstlist.repository;

import com.example.studenstlist.model.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class StudentRepository {

    private Map<Long, Student> students = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    @Value("${studentmanagement.create-students-at-startup:true}")
    private boolean createStudentsAtStartup;

    public Student addStudent(String firstName, String lastName, int age) {
        long newId = idCounter.getAndIncrement();
        Student newStudent = new Student(newId, firstName, lastName, age );
        students.put(newId, newStudent);
        return newStudent;
    }

    public void deleteStudent(long id) {
        students.remove(id);
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    public void clearAllStudents() {
        students.clear();
    }

    @PostConstruct
    public void init() {
        if (createStudentsAtStartup) {
            createInitialStudents();
        }
    }

    public void createInitialStudents() {
        addStudent("Mark", "Dobrov", 22);
        addStudent("Oleg", "Semshov", 19);
    }
}
