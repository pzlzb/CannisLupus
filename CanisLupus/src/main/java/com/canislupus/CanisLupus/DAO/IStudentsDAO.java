package com.canislupus.CanisLupus.DAO;
import com.canislupus.CanisLupus.Domain.Student;
import org.springframework.data.repository.CrudRepository;

public interface IStudentsDAO extends CrudRepository<Student,Long> {
    Student findBystudentEmail(String email);
}
