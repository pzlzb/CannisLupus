package com.canislupus.CanisLupus.Service;
import java.util.List;

import com.canislupus.CanisLupus.Domain.Student;
import com.canislupus.CanisLupus.Domain.Tutor;

public interface TutorService {
    public List<Tutor> listarTutors();
    public void guardar(Tutor tutor);
    public void eliminar(Tutor tutor);
    public Tutor encontrarTutor(Long idTutor);
    public void listarStudents();
    public Student actualizarStudent(Long id, Student student) throws Exception;
    public void generarRutaCritica() throws Exception;
    public void verReprobadas(Student student) throws Exception;
    public void verCursando(Student student) throws Exception;
    public void verAcreditadas(Student student) throws Exception;
    public void verNoCursadas(Student student) throws Exception;
    public void verDatos(Student student) throws Exception;
}