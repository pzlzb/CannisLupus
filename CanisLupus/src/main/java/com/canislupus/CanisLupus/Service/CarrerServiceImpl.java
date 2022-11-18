package com.canislupus.CanisLupus.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.canislupus.CanisLupus.DAO.ICarrerDAO;
import com.canislupus.CanisLupus.Domain.Carrer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class CarrerServiceImpl implements CarrerService {

    @Autowired
    private ICarrerDAO carrerDao;


    @Override
    @Transactional(readOnly = true)
    public List<Carrer> listarCarreras() {return carrerDao.findAll();}

    @Override
    @Transactional(readOnly = true)
    public Carrer encontrarCarreras(Long id) throws Exception{
        try {
            return carrerDao.findById(id).orElse(null);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } 
    }
    
}
