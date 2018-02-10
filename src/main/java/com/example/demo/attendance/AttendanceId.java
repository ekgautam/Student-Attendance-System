package com.example.demo.attendance;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AttendanceId implements Serializable {

    String date;

    int id;
    public AttendanceId() {

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AttendanceId(String date, int id) {
        this.date = date;
        this.id = id;
    }
}
