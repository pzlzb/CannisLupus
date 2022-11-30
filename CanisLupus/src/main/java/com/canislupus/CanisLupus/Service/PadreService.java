package com.canislupus.CanisLupus.Service;

import java.io.Serializable;
import java.util.List;

import com.canislupus.CanisLupus.Domain.Padre;

public interface PadreService<E extends Padre, ID extends Serializable>{
    public List<E> findAll() throws Exception;
    public E findById(ID id) throws Exception;
    public E findByUsername(String username) throws Exception;
    public E save(E entity) throws Exception;
    public E update(ID id, E entity) throws Exception;
    public boolean delete(ID id) throws Exception; 
}
