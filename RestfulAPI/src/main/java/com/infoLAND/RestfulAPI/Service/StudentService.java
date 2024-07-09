package com.infoLAND.RestfulAPI.Service;

import com.infoLAND.RestfulAPI.API.Model.Student;
import com.infoLAND.RestfulAPI.FakeDb.StudentFkDb;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private static StudentFkDb studentFkDb;

    public StudentService(StudentFkDb studentFkDb) {
        StudentService.studentFkDb = studentFkDb;
    }

//    Creation
    public void saveStudent(Student student) {
        studentFkDb.getStudentList().add(student);
    }

//    Retrieval -> All
    public List<Student> getAllStudents() {
        return studentFkDb.getStudentList();
    }

//    Retrieval -> One
    public Optional<Student> getStudentById(int id) {
        for (Student student : studentFkDb.getStudentList()) {
            if (student.getId() == id) {
                return Optional.of(student);
            }
        }
        return Optional.empty();
    }

//    Update
    public Optional<Student> updateStudent(int updateId, Student updateStudent) {
        for (Student student : studentFkDb.getStudentList()) {
            if (student.getId() == updateId) {
                student.setName(updateStudent.getName());
                return Optional.of(student);
            }
        }
        return Optional.empty();
    }

//    Delete
    public boolean deleteStudent(int deleteId) {
         return studentFkDb.getStudentList().removeIf(student -> student.getId() == deleteId);
    }
}
