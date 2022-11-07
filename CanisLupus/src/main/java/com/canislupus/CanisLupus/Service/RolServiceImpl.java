package com.canislupus.CanisLupus.Service;
import com.canislupus.CanisLupus.DAO.IAdministratorsDAO;
import com.canislupus.CanisLupus.DAO.IRolsDAO;
import com.canislupus.CanisLupus.DAO.ITutorsDAO;
import com.canislupus.CanisLupus.Domain.Administrator;
import com.canislupus.CanisLupus.Domain.Rol;
import com.canislupus.CanisLupus.Domain.Student;
import com.canislupus.CanisLupus.Domain.Tutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;

@Service("userDetailsService")
@Slf4j
public class RolServiceImpl implements RolService, UserDetailsService {
    @Autowired
    private IRolsDAO rolDao;
    @Autowired
    private IAdministratorsDAO adminDao;
    @Autowired
    private ITutorsDAO tutorDao;

    @Override
    @Transactional(readOnly=true)
    public UserDetails  loadUserByUsername(String email) throws UsernameNotFoundException{
        List<Rol> u = rolDao.findAll();
        UserDetails UserDetails = null;
        System.out.println("******************************************************************************\n");
        System.out.println("THERE ARE THE ROLES >> " + u.toString());
        System.out.println("******************************************************************************\n");
        if (adminDao.findByadminEmail(email) != null){
            Administrator usuario = adminDao.findByadminEmail(email);
            var rol =  new ArrayList<GrantedAuthority>();
            rol.add(new SimpleGrantedAuthority("ADMINISTRATOR"));
            //llave foranea 2  es para administradores->
            if(usuario.getAdminIdUser().getIdUser() == 2){UserDetails  = new User(usuario.getAdminName(), usuario.getAdminPw(), rol);}
        } else if (tutorDao.findBytutorEmail(email) != null){
            Tutor usuario = tutorDao.findBytutorEmail(email);
            var rol =  new ArrayList<GrantedAuthority>();
            rol.add(new SimpleGrantedAuthority("TUTOR"));
            //llave foranea 3  es para administradores->
            if(usuario.getTutorIdUser().getIdUser() == 3){UserDetails  = new User(usuario.getTutorName(), usuario.getTutorPw(), rol);}
        }
       return UserDetails;
    }

   // @Override
    @Transactional(readOnly=true)
    public void  UserByUsername(String rolEmail){
        System.out.println("******************************************************************************\n******************************************************************************");
        System.out.println("PRUEBA ROL, EMAIL_ROL" + rolEmail);
        System.out.println("******************************************************************************\n******************************************************************************");
        Rol usuario = rolDao.findByidUser(rolEmail);
        if (usuario == null){
            throw new UsernameNotFoundException(rolEmail);
        }
        System.out.println("******************************************************************************\n******************************************************************************");
        System.out.println(usuario.getIdUser() + usuario.getTypeUser());
        System.out.println("******************************************************************************\n******************************************************************************");
    }
    
    @Override
    @Transactional(readOnly = true)//Solo lectura de la db
    public List<Rol> listarRols() {
        // TODO Auto-generated method stub
        return (List<Rol>) rolDao.findAll();
    }

    @Override
    @Transactional//sin parametros, porque si va a modificar la db
    public void guardar(Rol rol) {
        // TODO Auto-generated method stub
        rolDao.save(rol);
    }

    @Override
    @Transactional
    public void eliminar(Rol rol) {
        // TODO Auto-generated method stub
        rolDao.delete(rol);
    }

    @Override
    @Transactional(readOnly = true)
    public Rol encontrarRol(Rol rol) {
        // TODO Auto-generated method stub
        return rolDao.findById((Long)rol.getIdUser()).orElse(null);
    } 
} 
