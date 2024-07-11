package com.infoLAND.RestfulAPI.Service;

import com.infoLAND.RestfulAPI.API.Model.Student;
import com.infoLAND.RestfulAPI.Repository.StudentRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepositroy studentRepository;

    @Autowired
    public StudentService(StudentRepositroy studentRepository) {
        this.studentRepository = studentRepository;
    }

//    Creation
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

//    Retrieval -> All
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

//    Retrieval -> One
    public Student getStudentById(Long id) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        return existingStudent.get();
    }

//    Update
    public Optional<Student> updateStudent(Long updateId, Student updateStudent) {
        Optional<Student> existingStudent = studentRepository.findById(updateId);
        if (existingStudent.isPresent()) {
            Student student = existingStudent.get();
            student.setName(updateStudent.getName());
            student.setAge(updateStudent.getAge());
            student.setEmail(updateStudent.getEmail());
            student.setPhone(updateStudent.getPhone());

            studentRepository.save(student);
            return Optional.of(student);
        }
        return Optional.empty();
    }

//    Delete
    public void deleteStudent(Long deleteId) {
         studentRepository.deleteById(deleteId);
    }

//    Method to check student
    public boolean checkStudent(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.isPresent();
    }
}
