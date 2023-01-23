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
    private IStudentsDAO studentDAO;
    private IKardexDAO iKardexDAO;

    public KardexServiceImpl(IStudentsDAO studentsDAO, IKardexDAO iKardexDAO){
       this.studentDAO = studentsDAO;
       this.iKardexDAO = iKardexDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public Kardex findById(Long id) throws Exception {
        return kardexDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Kardex save(Kardex kardex) throws Exception {
        try {
            if(!kardexDao.existsById(kardex.getIdKardex())){
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
    public Kardex update(Kardex kardex) throws Exception {
        try {
            System.out.println("el  id del kardex es: "+kardex.getIdKardex());
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
    public boolean delete(Long id) throws Exception {
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
}