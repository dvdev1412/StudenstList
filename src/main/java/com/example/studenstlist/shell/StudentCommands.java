package com.example.studenstlist.shell;

import com.example.studenstlist.events.StudentCreatedEvent;
import com.example.studenstlist.events.StudentDeletedEvent;
import com.example.studenstlist.model.Student;
import com.example.studenstlist.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@RequiredArgsConstructor
public class StudentCommands {

    private final StudentRepository studentRepository;
    private final ApplicationEventPublisher publisher;

    @ShellMethod("display all students.")
    public String displayAllStudents() {
        return studentRepository.getAllStudents().toString();
    }

    @ShellMethod("Add a student.")
    public String addStudent(String firstName, String lastName, int age) {
        Student newStudent = studentRepository.addStudent(firstName, lastName, age);
        publisher.publishEvent(new StudentCreatedEvent(this, newStudent));
        return "Student created" + " " + newStudent;
    }

    @ShellMethod("Delete a student.")
    public String deleteStudent(Long id) {
        studentRepository.deleteStudent(id);
        publisher.publishEvent(new StudentDeletedEvent(this, id));
        return "Student deleted" + " " + id;
    }

    @ShellMethod("Clear all students.")
    public String clearAllStudents() {
        studentRepository.clearAllStudents();
        return "All students cleared";
    }

}
