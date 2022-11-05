package com.canislupus.CanisLupus.Service;
import java.util.List;
import com.canislupus.CanisLupus.Domain.Student;

public interface StudentService {
    public List<Student> listarPupils();
    public void guardar(Student pupil);
    public void eliminar(Student pupil);
    public Student encontrarStudent(Student pupil);
}