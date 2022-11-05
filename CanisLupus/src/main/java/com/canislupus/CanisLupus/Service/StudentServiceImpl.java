package com.canislupus.CanisLupus.Service;
import java.util.List;
import com.canislupus.CanisLupus.DAO.IStudentsDAO;
import com.canislupus.CanisLupus.Domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServiceImpl implements StudentService {
    
    @Autowired
    private IStudentsDAO studentDao;

    @Override
    @Transactional(readOnly = true)
    public List<Student> listarPupils(){
        return (List<Student>) studentDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Student student){
        studentDao.save(student);
    }

    @Override
    @Transactional
    public void eliminar(Student student){
        studentDao.delete(student);
    }

    @Override
    @Transactional
    public Student encontrarStudent(Student student){
        return studentDao.findById((Long)student.getIdStudent()).orElse(null);
    }
}
