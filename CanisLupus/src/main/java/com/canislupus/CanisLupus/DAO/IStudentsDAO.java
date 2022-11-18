package com.canislupus.CanisLupus.DAO;
import com.canislupus.CanisLupus.Domain.Student;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface IStudentsDAO extends CrudRepository<Student,Long> {
    //Student findBystudentEmail(String email);
    Optional<Student> findBystudentEmail(String usernameList);
    //<Student> findByStudentEmail(String studentEmail);
}
