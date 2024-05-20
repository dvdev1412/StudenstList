package com.example.studenstlist.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {

    private Long id;
    private String firstName;
    private String lastName;
    private int age;
}
