package com.canislupus.CanisLupus.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.canislupus.CanisLupus.DAO.PadreRepository;
import com.canislupus.CanisLupus.Domain.Padre;



public abstract class PadreServiceImpl <E extends Padre, ID extends Serializable> implements PadreService<E, ID>  {
    
    protected PadreRepository<E,ID> padreRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public PadreServiceImpl(PadreRepository<E, ID> padreRepository) {
        this.padreRepository = padreRepository;
    }

    @Override
    @Transactional
    public List<E> findAll() throws Exception{
        try {
            List<E> entities = padreRepository.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E findById(ID id) throws Exception{
        try {
            //System.out.println("SERVICIO STUDENT RECIBIENDO DE DATOS DE DAO: \n"+studentDao.findById(id).orElse(null).toString());
            return padreRepository.findById(id).orElse(null);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    // public E findByUsername(String username) throws Exception{
    //     try {
    //         return padreRepository.findBystudentEmail(username).orElse(null);
    //     } catch (Exception e) {
    //         throw new Exception(e.getMessage());
    //     }
    // }
    
    @Override
    @Transactional
    public E save(E entity) throws Exception{
        try {
            if (!padreRepository.existsById((ID)entity.getId())){//MATRICULA, FALTA VALIDAR EMAIL
                //String encodedPassword = bCryptPasswordEncoder.encode(entity.getStudentPw());
                //entity.setStudentPw(encodedPassword);
                return padreRepository.save(entity);
                //return entity;
            }else{
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(ID id) throws Exception{
        try {
            if(padreRepository.existsById(id)){
                padreRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }   
    }

    @Override
    @Transactional
    public E update(ID id, E entity) throws Exception{
        try {
            Optional<E> entityOptional = padreRepository.findById(id);//error si no encuentra ese id
            E entityUpdate = entityOptional.get();
            //entity.setId(id);
            entityUpdate = padreRepository.save(entity);
            return entityUpdate;
            //System.out.println("se encontro user en DAO: XD");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }   
}