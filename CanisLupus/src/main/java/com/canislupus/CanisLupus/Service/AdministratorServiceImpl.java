package com.canislupus.CanisLupus.Service;
import com.canislupus.CanisLupus.DAO.IAdministratorsDAO;
import com.canislupus.CanisLupus.Domain.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import java.util.List;


@Service
@Slf4j
public class AdministratorServiceImpl implements AdministratorService{
    @Autowired
    private IAdministratorsDAO adminDao;
    
    @Override
    @Transactional(readOnly = true)//Solo lectura de la db
    public List<Administrator> listarAdministrators() {
        // TODO Auto-generated method stub
        return (List<Administrator>) adminDao.findAll();
    }

    @Override
    @Transactional//sin parametros, porque si va a modificar la db
    public void guardar(Administrator admin) {
        // TODO Auto-generated method stub
        adminDao.save(admin);
    }

    @Override
    @Transactional
    public void eliminar(Administrator admin) {
        // TODO Auto-generated method stub
        adminDao.delete(admin);
    }

    @Override
    @Transactional(readOnly = true)
    public Administrator encontrarAdmin(Administrator admin) {
        // TODO Auto-generated method stub
        return adminDao.findById((Long)admin.getIdAdmin()).orElse(null);
    }
}