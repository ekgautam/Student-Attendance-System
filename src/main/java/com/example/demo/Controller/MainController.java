package com.example.demo.Controller;

import com.example.demo.DTOs.AttendanceDTO;
import com.example.demo.Service.SmartData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    SmartData smartData;


    //get attendance of all students on date
    @RequestMapping("/{month}/{id}")
    public AttendanceDTO getallname(@PathVariable String month, @PathVariable int id)

    {
        return smartData.getsmartdata(month,id);
    }








}
