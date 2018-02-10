package com.example.demo.attendance;


import com.example.demo.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/students/attendance")
public class AttendanceController {

    @Autowired
    AttendanceService attendanceService;


    //get attendance of all students on date
    @RequestMapping("/{date}")
    public List<Attendance> getallname(@PathVariable String date)

    {
        return attendanceService.getall(date);
    }


    //get particular student attendance
    @RequestMapping("/{date}/{rno}")
    public Attendance getparticular(@PathVariable int rno, @PathVariable String date)
    {
        return attendanceService.getdatewise(rno,date);
    }

    //get month attendance for a particular student
    @RequestMapping("/monthly/{month}/{rno}")
    public List<Attendance> getparticularmonth(@PathVariable int rno, @PathVariable String month)
    {
        return attendanceService.getmonthwise(rno,month);
    }

    //insert attendance on date d
    @RequestMapping(method = RequestMethod.POST,value="/{date}/{rno}")
    public void addstudent(@RequestBody Attendance s,@PathVariable int rno,@PathVariable String date)

    {

        s.setStudent(new Student(rno,""));
        attendanceService.addnew(s,date,rno);
    }





}
