package com.example.demo.student;

import com.example.demo.attendance.Attendance;
import com.example.demo.attendance.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    AttendanceRepository attendanceRepository;


    public List<Student> getall() {

        List<Student> st=new ArrayList<>();
        studentRepository.findAll().forEach(st::add);
        return st;

    }

    public Student get(int rno) {

        return studentRepository.findOne(rno);
    }

    public void addnew(Student s) {

        studentRepository.save(s);
    }

    public void update(Student s, int rno) {


        List<Attendance> at=new ArrayList<>();
        int t=0,p=0;
        attendanceRepository.findByAttendanceId_Id(rno).forEach(at::add);
        t=at.size();
        for(int i=0;i<at.size();i++)
        {
            Attendance a=at.get(i);
            if(a.getStatus().equals("present"))
            {
                p++;
            }

        }
        float percent  = ((p * 100)/ t) ;
        s.setPercent((int) Math.round(percent));
        studentRepository.save(s);
    }

    public void delete(int rno) {

        studentRepository.delete(rno);
    }
}
