package com.example.apiTest.students;

import org.springframework.format.annotation.DateTimeFormat;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Student {

    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    private Long id;
    private String name;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date birthdayInDate;

    private long birthday;

    public Student() {

    }

    public Student(String name, long birthday) throws ParseException {


        this.birthday = birthday;
        this.name = name;
        this.birthdayInDate = new Date(birthday);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getBirthday() throws ParseException {
        return birthdayInDate.getTime();
    }

    public Date getBirthdayInDate() {
        birthdayInDate=new Date(birthday);
        return birthdayInDate;
    }



    @Override
    public String toString() {
        return "Student{" +
                ", name='" + name + '\'' +
                ", birthday=" + new Date(birthday) +
                '}';
    }
}
