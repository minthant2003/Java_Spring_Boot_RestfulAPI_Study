package com.infoLAND.RestfulAPI.Repository;

import com.infoLAND.RestfulAPI.API.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepositroy extends JpaRepository<Student, Long> {
}
