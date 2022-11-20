package com.canislupus.CanisLupus.Service;
import java.util.List;
import java.util.Optional;

import com.canislupus.CanisLupus.DAO.IStudentsDAO;
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
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional(readOnly = true)
    public List<Student> listarPupils(){
        return (List<Student>) studentDao.findAll();
    }

    @Override
    @Transactional
    public Student guardar(Student student) throws Exception{
        try {
            if (!studentDao.existsById(student.getIdStudent())){//mATRICULA, FALTA VALIDAR EMAIL
                String encodedPassword = bCryptPasswordEncoder.encode(student.getStudentPw());
                student.setStudentPw(encodedPassword);
                studentDao.save(student);
            return student;
        }else{
            throw new Exception();
        }
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean eliminar(Long id) throws Exception{
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
    @Transactional(readOnly = true)
    public Student encontrarStudent(Long id) throws Exception{
        try {
            System.out.println("SERVICIO STUDENT RECIBIENDO DE DATOS DE DAO: \n"+studentDao.findById(id).orElse(null).toString());
            return studentDao.findById(id).orElse(null);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    public Student encontrarStudent(String username) throws Exception{
        try {
            return studentDao.findBystudentEmail(username).orElse(null);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Student actualizarStudent(Long id, Student student) throws Exception{
        try {
            Optional<Student> studentAux = studentDao.findById(id);//error si no encuentra ese id
            student.setIdStudent(id);
            return studentDao.save(student);
            //System.out.println("se encontro user en DAO: XD");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    
}
