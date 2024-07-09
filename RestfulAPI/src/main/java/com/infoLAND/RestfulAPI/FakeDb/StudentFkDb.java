package com.infoLAND.RestfulAPI.FakeDb;

import com.infoLAND.RestfulAPI.API.Model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentFkDb {
//    Fake DB
    private final List<Student> studentList = new ArrayList<>();

    public StudentFkDb() {
        studentList.add(new Student(1, "Min Thant"));
        studentList.add(new Student(2, "Min Khant"));
        studentList.add(new Student(3, "Nay Oo Kyaw"));
    }

    public List<Student> getStudentList() {
        return studentList;
    }
}
