package com.canislupus.CanisLupus.Service;
import com.canislupus.CanisLupus.DAO.IAdministratorsDAO;
import com.canislupus.CanisLupus.DAO.IRolsDAO;
import com.canislupus.CanisLupus.DAO.IStudentsDAO;
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
    @Autowired
    private IStudentsDAO studentDao;

    @Override
    @Transactional(readOnly=true)
    public UserDetails  loadUserByUsername(String username) throws UsernameNotFoundException{
        List<Rol> rols = rolDao.findAll();
        UserDetails UserDetails = null;
        
        System.out.println("******************************************************************************\n");
        System.out.println("ROLS: " + rols.toString());
        System.out.println("******************************************************************************\n");

        if (adminDao.findByadminEmail(username) != null){
            System.out.println("User found: "+adminDao.findByadminEmail(username).toString());
            //ser found: Administrator(idAdmin=1, adminName=Mario, adminLastName=Rossainz Lopez, adminEmail=mario@buap.mx, 
            //adminPw=$2a$10$TGzaIvgFcwMmw1sBmI6HVeGFSRpdww1XF05JJSSDgyCqzHopdSpDu, adminIdUser=Rol(idUser=2, typeUser=ADMINISTRATOR))
            Administrator usuario = adminDao.findByadminEmail(username);
            var rol =  new ArrayList<GrantedAuthority>();
            rol.add(new SimpleGrantedAuthority("ROLE_ADMINISTRATOR"));
            //llave foranea 2  es para administradores->
            if(usuario.getAdminIdUser().getIdUser() == 2){UserDetails  = new User(usuario.getAdminName(), usuario.getAdminPw(), rol);}
        } else if (tutorDao.findBytutorEmail(username) != null){
            Tutor usuario = tutorDao.findBytutorEmail(username);
            var rol =  new ArrayList<GrantedAuthority>();
            rol.add(new SimpleGrantedAuthority("ROLE_TUTOR"));
            //llave foranea 3  es para administradores->
            if(usuario.getTutorIdUser().getIdUser() == 3){UserDetails  = new User(usuario.getTutorName(), usuario.getTutorPw(), rol);}
        } else if (studentDao.findBystudentEmail(username) != null) {
            Student usuario = studentDao.findBystudentEmail(username).orElse(null);
            var rol =  new ArrayList<GrantedAuthority>();
            rol.add(new SimpleGrantedAuthority("ROLE_STUDENT"));
            //llave foranea 3  es para administradores->
            if(usuario.getIdStudent() == 4){UserDetails  = new User(usuario.getStudentName(), usuario.getStudentPw(), rol);}

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
        return (List<Rol>) rolDao.findAll();
    }

    @Override
    @Transactional//sin parametros, porque si va a modificar la db
    public void guardar(Rol rol) {
        rolDao.save(rol);
    }

    @Override
    @Transactional
    public void eliminar(Rol rol) {
        rolDao.delete(rol);
    }

    @Override
    @Transactional(readOnly = true)
    public Rol encontrarRol(Rol rol) {
        return rolDao.findById((Long)rol.getIdUser()).orElse(null);
    } 
} 
