package com.canislupus.CanisLupus.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.canislupus.CanisLupus.DAO.IKardexDAO;
import com.canislupus.CanisLupus.DAO.IStudentsDAO;
import com.canislupus.CanisLupus.Domain.Kardex;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KardexServiceImpl implements KardexService {
    
    @Autowired
    private IKardexDAO kardexDao;
    @Autowired
    private IStudentsDAO studentDao;

    @Override
    @Transactional(readOnly = true)
    public Kardex encontrarKardex(Long id) throws Exception {
        return kardexDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Kardex guardarKardex(Kardex kardex) throws Exception {
        try {
            if(kardexDao.existsById(kardex.getIdKardex())){
                return kardexDao.save(kardex);
            }else{
                throw new Exception();
            }            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Kardex actualizKardex(Kardex kardex) throws Exception {
        try {
            if(kardexDao.existsById(kardex.getIdKardex())){
                return kardexDao.save(kardex);
            }else{
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean eliminarKardex(Long id) throws Exception {
        try {
            if(kardexDao.existsById(id)){
                kardexDao.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());   
        }   
    }

    private IStudentsDAO iStudentsDAO;
    private IKardexDAO iKardexDAO;

    public KardexServiceImpl(IStudentsDAO iStudentsDAO, IKardexDAO iKardexDAO){
       this.iStudentsDAO = iStudentsDAO;
       this.iKardexDAO = iKardexDAO;
    }
}
