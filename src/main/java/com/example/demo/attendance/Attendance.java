package com.example.demo.attendance;


import com.example.demo.student.Student;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;



import javax.persistence.*;
import java.util.Date;

@Entity

@Data
public class Attendance {
    @EmbeddedId


    private AttendanceId attendanceId;


    String status;

    @ManyToOne
    @JsonIgnore
    //@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
    //@JsonIdentityReference(alwaysAsId = true)
    Student student;


    public Attendance() {

    }

    public Attendance(AttendanceId attendanceId, String status, Student student) {

        this.attendanceId = attendanceId;
        this.status = status;
        this.student = student;
    }
}
