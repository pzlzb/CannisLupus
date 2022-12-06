package com.canislupus.CanisLupus.Service;
import java.util.ArrayList;
import java.util.List;
import com.canislupus.CanisLupus.DAO.ITutorsDAO;
import com.canislupus.CanisLupus.Domain.Student;
import com.canislupus.CanisLupus.Domain.Tutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("UserDetailsService")
@Slf4j
public class TutorServiceImpl implements TutorService, UserDetailsService{
    
    @Autowired
    private ITutorsDAO tutorDao;


    @Override
    @Transactional(readOnly=true)
    public UserDetails  loadUserByUsername(String tutorEmail) throws UsernameNotFoundException{
        //System.out.println("******************************************************************************\n******************************************************************************");
        // System.out.println("this is the email tutor>> " + tutorEmail);
        // System.out.println("******************************************************************************\n******************************************************************************");
        Tutor usuario = tutorDao.findBytutorEmail(tutorEmail);
        if (usuario == null){
            throw new UsernameNotFoundException(tutorEmail);
        }
        var rol =  new ArrayList<GrantedAuthority>();
        rol.add(new SimpleGrantedAuthority("TUTOR"));
        UserDetails UserDetails = null;
        if(usuario.getTutorIdUser().getIdUser() == 3){//llave foranea 3  es para administradores
            UserDetails  = new User(usuario.getTutorName(), usuario.getTutorPw(), rol);
        }
        System.out.println("******************************************************************************\n******************************************************************************");
        System.out.println(UserDetails.toString());
        System.out.println("******************************************************************************\n******************************************************************************");
        
        return UserDetails;
    }


    @Override
    @Transactional(readOnly = true)
    public List<Tutor> listarTutors(){
        return (List<Tutor>) tutorDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Tutor tutor){
        tutorDao.save(tutor);
    }

    @Override
    @Transactional
    public void eliminar(Tutor tutor) {
        tutorDao.delete(tutor);
    }

    @Override
    @Transactional(readOnly = true)
    public Tutor encontrarTutor(Tutor tutor) {
        return tutorDao.findById((Long)tutor.getIdTutor()).orElse
        (null);
    }


    @Override
    public void listarStudents() {
    }


    @Override
    public Student actualizarStudent(Long id, Student student) throws Exception {
        return null;
    }


    @Override
    public void generarRutaCritica() throws Exception {
    }


    @Override
    public void verReprobadas(Student student) throws Exception {
    }


    @Override
    public void verCursando(Student student) throws Exception {
    }


    @Override
    public void verAcreditadas(Student student) throws Exception {
    }


    @Override
    public void verNoCursadas(Student student) throws Exception {
    }


    @Override
    public void verDatos(Student student) throws Exception {
    }
}
