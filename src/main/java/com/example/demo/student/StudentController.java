package com.example.demo.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping("/students")
    public List<Student> getallname()
    {
        return studentService.getall();
    }


    //get particular demo detail
    @RequestMapping("/students/{rno}")
    public Student getparticular(@PathVariable int rno)
    {
        return studentService.get(rno);
    }

    //insert new demo
    @RequestMapping(method = RequestMethod.POST,value="/students")
    public void addstudent(@RequestBody Student s)
    {
        studentService.addnew(s);
    }

    @RequestMapping(method = RequestMethod.PUT,value="/students/{rno}")
    public void addstudent(@RequestBody Student s,@PathVariable int rno)
    {
        studentService.update(s,rno);
    }
    @RequestMapping(method = RequestMethod.DELETE,value="/students/{rno}")
    public void deletestudent(@RequestBody Student s,@PathVariable int rno)
    {
        studentService.delete(rno);
    }


}
