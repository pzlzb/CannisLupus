package com.canislupus.CanisLupus.Service;
import java.util.List;

import com.canislupus.CanisLupus.Domain.Kardex_Course2;
import com.canislupus.CanisLupus.Domain.Student;

public interface StudentService {
    public List<Student> findAll();
    public Student findById(Long id) throws Exception;
    public Student findByUsername(String username) throws Exception;
    public Student save(Student student) throws Exception;
    public Student update(Long id, Student student) throws Exception;
    public boolean delete(Long id) throws Exception;
    public void generarRutaCritica() throws Exception;
    public List<Kardex_Course2> verReprobadas(Long id) throws Exception;
    public List<Kardex_Course2> verCursando(Long id) throws Exception;
    public List<Kardex_Course2> verAcreditadas(Long id) throws Exception;
    public List<Kardex_Course2> verNoCursadas(Long id) throws Exception;
    public void verDatos(Long id) throws Exception;
}