package com.example.studenstlist.events;

import com.example.studenstlist.model.Student;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StudentEventListener {

    @EventListener
    public void handleStudentCreated(StudentCreatedEvent event) {
        Student student = event.getStudent();
        System.out.println("Student created: " + event.getStudent());
    }
    @EventListener
    public void handleStudentDeleted(StudentDeletedEvent event) {
        Long studentId = event.getStudentId();
        System.out.println("Student deleted with ID: " + studentId);
    }
}
