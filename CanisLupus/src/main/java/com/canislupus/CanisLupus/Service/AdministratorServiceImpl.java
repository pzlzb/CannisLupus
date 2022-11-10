package com.canislupus.CanisLupus.Service;
import com.canislupus.CanisLupus.DAO.IAdministratorsDAO;
import com.canislupus.CanisLupus.Domain.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
@Slf4j
public class AdministratorServiceImpl implements AdministratorService{
    
    @Autowired
    private IAdministratorsDAO adminDao;
    
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    
    @Override
    @Transactional(readOnly = true)
    public List<Administrator> listarAdministrators() throws Exception {
        try {
            List<Administrator> admins = adminDao.findAll();
            return admins;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        //return (List<Administrator>) adminDao.findAll();
    }

    @Override
    @Transactional//sin parametros, porque si va a modificar la db
    public Administrator guardar(Administrator admin) throws Exception {
        try {
            if (!adminDao.existsById(admin.getIdAdmin())){//mATRICULA, FALTA VALIDAR EMAIL
                String encodedPassword = bCryptPasswordEncoder.encode(admin.getAdminPw());
                admin.setAdminPw(encodedPassword);
                adminDao.save(admin);
            return admin;
            }else{
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        
    }

    @Override
    @Transactional
    public boolean eliminar(Long id) throws Exception {
        try {
            if (adminDao.existsById(id)){
                adminDao.delete(adminDao.getById(id));//duda si funciona
                return true;
            } else{
                throw new Exception();
            }
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        
    }

    @Override
    @Transactional(readOnly = true)
    public Administrator encontrarAdmin(Long id) throws Exception{
        try {
            return adminDao.findById(id).orElse(null);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Override
    @Transactional(readOnly = true)
    public Administrator actualizarAdmin(Long id, Administrator admin) throws Exception{
        try {
            Optional<Administrator> adminAux = adminDao.findById(id);//error si no encuentra ese id
            Administrator a = adminAux.get();
            a = adminDao.save(admin);
            return  admin;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}