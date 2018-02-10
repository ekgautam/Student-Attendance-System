package com.example.demo.student;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
@Data
@Entity
public class Student {
    @Id
    int id;
    String name;
    int percent;


    public Student() {

    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.percent = percent;
    }


}
