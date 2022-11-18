package com.canislupus.CanisLupus.Service;
import java.util.List;
import com.canislupus.CanisLupus.Domain.Student;

public interface StudentService {
    public List<Student> listarPupils();
    public Student guardar(Student pupil) throws Exception;
    public boolean eliminar(Long id) throws Exception;
    public Student encontrarStudent(Long id) throws Exception;
    public Student encontrarStudent(String username) throws Exception;
    public Student actualizarStudent(Long id, Student student) throws Exception;
    
}