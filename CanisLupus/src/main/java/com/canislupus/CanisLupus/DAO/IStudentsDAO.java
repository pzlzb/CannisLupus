package com.canislupus.CanisLupus.DAO;
import com.canislupus.CanisLupus.Domain.Student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentsDAO extends JpaRepository<Student,Long> {
    //Student findBystudentEmail(String email);
    Optional<Student> findBystudentEmail(String usernameList);
}