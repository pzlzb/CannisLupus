package com.canislupus.CanisLupus.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.canislupus.CanisLupus.DAO.CourseRepository;
import com.canislupus.CanisLupus.DAO.IKardexDAO;
import com.canislupus.CanisLupus.DAO.IStudentsDAO;
import com.canislupus.CanisLupus.DAO.Kardex_CourseRepository;
import com.canislupus.CanisLupus.Domain.Course;
import com.canislupus.CanisLupus.Domain.Kardex;
import com.canislupus.CanisLupus.Domain.Kardex_Course2;
import com.canislupus.CanisLupus.Domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServiceImpl implements StudentService {
    
    @Autowired
    private IStudentsDAO studentDao;
    @Autowired
    private IKardexDAO kardexDAO;
    @Autowired
    private Kardex_CourseRepository kcRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional(readOnly = true)
    public List<Student> findAll(){
        return (List<Student>) studentDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Student findById(Long id) throws Exception{
        try {
            return studentDao.findById(id).orElse(null);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    public Student findByUsername(String username) throws Exception{
        try {
            return studentDao.findBystudentEmail(username).orElse(null);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Student save(Student student) throws Exception{
        try {
            if (!studentDao.existsById(student.getIdStudent())){//mATRICULA, FALTA VALIDAR EMAIL
                String encodedPassword = bCryptPasswordEncoder.encode(student.getStudentPw());
                student.setStudentPw(encodedPassword);
                return studentDao.save(student);
            }else{
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Student update(Long id, Student student) throws Exception{
        try {
            Optional<Student> studentAux = studentDao.findById(id);//error si no encuentra ese id
            Student a = studentAux.get();
            a=student;
            student.setIdStudent(id);
            a.setStudentPw(bCryptPasswordEncoder.encode(a.getStudentPw()));
            return studentDao.save(a);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception{
        try {
            if(studentDao.existsById(id)){
                studentDao.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }   
    }

    @Override
    public void generarRutaCritica() throws Exception {   

    }

    @Override
    public List<Kardex_Course2> verReprobadas(Long id) throws Exception {
        List<Kardex_Course2> reprobadas =  new ArrayList<>();
        if(kardexDAO.existsById(id)){
            Optional<Kardex> k = kardexDAO.findById(id);
            if(k != null){
                Kardex kardex = k.get();
                reprobadas = kcRepository.findByGraduateContainingAndKardex(5D,kardex.getIdKardex());
            }
        }
        return reprobadas;
    }

    @Override
    public List<Kardex_Course2> verCursando(Long id) throws Exception {
        
        return null;
    }

    @Override
    public List<Kardex_Course2> verAcreditadas(Long id) throws Exception {
        
        return null;
    }

    @Override
    public List<Kardex_Course2> verNoCursadas(Long id) throws Exception {
        
        return null;
    }

    @Override
    public void verDatos(Long id) throws Exception {
        
        
    }   
}