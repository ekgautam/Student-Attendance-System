package com.example.demo.attendance;

import com.example.demo.student.StudentRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    AttendanceRepository attendanceRepository;


    public List<Attendance> getall(String date) {

        List<Attendance> at=new ArrayList<>();
        attendanceRepository.findByAttendanceId_Date(date).forEach(at::add);
        return at;

    }

    public Attendance getdatewise(int rno, String date) {

        List<Attendance> at=new ArrayList<>();
        attendanceRepository.findByAttendanceId_Date(date).forEach(at::add);
        for(int i=0;i<at.size();i++)
        {
            Attendance a=at.get(i);
            if(a.getAttendanceId().getId()==rno)
                return a;
        }
        return null;
    }

    public void addnew(Attendance s,String date,int rno) {

        AttendanceId attendanceId=new AttendanceId(date,rno);
        s.setAttendanceId(attendanceId);
        attendanceRepository.save(s);
    }


    public List<Attendance> getmonthwise(int rno, String month) {

        List<Attendance> at=new ArrayList<>();
        List<Attendance> finat=new ArrayList<>();
        attendanceRepository.findByAttendanceId_Id(rno).forEach(at::add);
        for(int i=0;i<at.size();i++)
        {
            Attendance a=at.get(i);
            if(a.getAttendanceId().getDate().regionMatches(3,month,0,2))
            {
                finat.add(a);
            }
        }
        return finat;


    }
}
