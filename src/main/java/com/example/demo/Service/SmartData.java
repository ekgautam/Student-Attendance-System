package com.example.demo.Service;

import com.example.demo.DTOs.AttendanceDTO;
import com.example.demo.Utility.Month;
import com.example.demo.attendance.Attendance;
import com.example.demo.attendance.AttendanceService;
import com.example.demo.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SmartData {

    @Autowired
    AttendanceService attendanceService;
    @Autowired
    StudentService studentService;






    Month m;

    public AttendanceDTO getsmartdata(String month, int id) {

        List<Attendance> monthwise=attendanceService.getmonthwise(id,month);

        int tot=monthwise.size();
        int p=0;
        for(int i=0;i<monthwise.size();i++)
        {
            Attendance a=monthwise.get(i);

            if(a.getStatus().equals("present"))
                p++;
        }

        AttendanceDTO attendanceDTO=new AttendanceDTO();

        int a=Integer.parseInt(month);
        switch(a)
        {
            case 1: m=Month.JAN;
                break;
            case 2: m=Month.FEB;
                break;
            case 3: m=Month.MAR;
                break;
            case 4: m=Month.APR;
                break;
            case 5: m=Month.MAY;
                break;
            case 6: m=Month.JUN;
                break;
            case 7: m=Month.JUL;
                break;
            case 8: m=Month.AUG;
                break;
            case 9: m=Month.SEP;
                break;
            case 10: m=Month.OCT;
                break;
            case 11: m=Month.NOV;
                break;
            case 12: m=Month.DEC;
                break;


        }

        attendanceDTO.setTotal(tot);
        attendanceDTO.setCount(p);
        attendanceDTO.setId(id);
        attendanceDTO.setMonth(m);;
        attendanceDTO.setPercent(studentService.get(id).getPercent());

        return attendanceDTO;



    }
}
