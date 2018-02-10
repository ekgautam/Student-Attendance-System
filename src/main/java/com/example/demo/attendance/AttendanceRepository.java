package com.example.demo.attendance;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;



public interface AttendanceRepository extends CrudRepository<Attendance,AttendanceId> {

    public List<Attendance> findByAttendanceId_Date(String date);
    public List<Attendance> findByAttendanceId_Id(int id);
}
