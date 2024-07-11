package com.infoLAND.RestfulAPI.API.Controller;

import com.infoLAND.RestfulAPI.API.ExceptionHandler.ValidationExceptionHandler;
import com.infoLAND.RestfulAPI.API.Model.Student;
import com.infoLAND.RestfulAPI.API.ResponseHandler.ResponseHandler;
import com.infoLAND.RestfulAPI.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class StudentController extends ValidationExceptionHandler {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

//    Creation
    @PostMapping("/student")
    public ResponseEntity<Object> saveStudent(@Valid @RequestBody Student student) {
        studentService.saveStudent(student);
        return new ResponseHandler().generateCustomResponse("New student has been created.", HttpStatus.CREATED, Optional.of(student));
    }

//    Retrieval
    @GetMapping("/students")
    public ResponseEntity<Object> getAllStudents() {
        List<Student> studentList = studentService.getAllStudents();
        if (studentList.isEmpty()) {
            return new ResponseHandler().generateCustomResponse("There is no data.", HttpStatus.NOT_FOUND, Optional.empty());
        }
        return new ResponseHandler().generateCustomResponse("Data of all students.", HttpStatus.OK, Optional.of(studentList));
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Object> getStudentById(@PathVariable Long id) {
        if (studentService.checkStudent(id)) {
            Student student = studentService.getStudentById(id);
            return new ResponseHandler().generateCustomResponse("Data fetched.", HttpStatus.OK, Optional.of(student));
        }
        return new ResponseHandler().generateCustomResponse("No student found.", HttpStatus.NOT_FOUND, Optional.empty());
    }

//    Update
    @PutMapping("/studentsUpdate/{id}")
    public ResponseEntity<Object> updateStudent(@PathVariable Long id,@Valid @RequestBody Student student) {
        Optional<Student> updatedStudent = studentService.updateStudent(id, student);
        if (updatedStudent.isPresent()) {
            return new ResponseHandler().generateCustomResponse("Student is updated.", HttpStatus.OK, Optional.of(updatedStudent));
        }
        return new ResponseHandler().generateCustomResponse("Student is not found.", HttpStatus.NOT_FOUND, Optional.empty());
    }

//    Delete
    @DeleteMapping("/studentsDelete/{id}")
    public ResponseEntity<Object> deleteStudent(@PathVariable Long id) {
        if (studentService.checkStudent(id)) {
            studentService.deleteStudent(id);
            return new ResponseHandler().generateCustomResponse("Student is removed.", HttpStatus.OK, Optional.empty());
        }
        return new ResponseHandler().generateCustomResponse("Student is not found.", HttpStatus.NOT_FOUND, Optional.empty());
    }
}
