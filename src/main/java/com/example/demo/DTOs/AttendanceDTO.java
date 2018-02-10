package com.example.demo.DTOs;

import com.example.demo.Utility.Month;
import com.example.demo.attendance.AttendanceRepository;
import com.example.demo.student.StudentRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class AttendanceDTO {

    private Month month;
    private int count;
    private int total;
    private int percent;
    private int id;



    public AttendanceDTO(Month month, int count, int total, int percent, int id) {
        this.month = month;
        this.count = count;
        this.total=total;

        this.percent = percent;
        this.id = id;
    }
    public AttendanceDTO() {


    }


}
