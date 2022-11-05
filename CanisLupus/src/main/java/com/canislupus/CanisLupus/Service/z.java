//AdministratorUsuarioService
/*package com.canislupus.CanisLupus.Service;
import com.canislupus.CanisLupus.DAO.IAdministratorsDAO;
import com.canislupus.CanisLupus.Domain.Administrator;
import com.canislupus.CanisLupus.Domain.Rol;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service("userDetailsService")
@Slf4j
public class AdministratorUsuarioService implements UserDetailsService{

    @Autowired
    private IAdministratorsDAO usuarioDao;

    @Override
    @Transactional(readOnly=true)
    public UserDetails  loadUserByUsername(String username) throws UsernameNotFoundException{
        Administrator usuario = usuarioDao.findByUsername(username);
        if (usuario == null){
            throw new UsernameNotFoundException(username);
        }
        var rol =  new ArrayList<GrantedAuthority>();
        rol.add(new SimpleGrantedAuthority("ADMINISTRATOR"));
        UserDetails UserDetails = null;
        if(usuario.getIdUser().getIdUser() == 1)
            UserDetails  = new User(usuario.getAdminName(), usuario.getAdminPw(), rol);
        /*var roles = new ArrayList<GrantedAuthority>();
        //for(Roles rol:usuario.getAdminIdUser(){
            Roles rol,x;
            rol = usuario.getIdAdmin();
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
       // return new Administrator(usuario.getAdminName(), usuario.getAdminPw(), roles);
        return UserDetails;
    }
}*/
