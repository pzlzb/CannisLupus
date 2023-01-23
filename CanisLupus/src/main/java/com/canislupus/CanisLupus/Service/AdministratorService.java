package com.canislupus.CanisLupus.Service;
import java.util.List;
import com.canislupus.CanisLupus.Domain.Administrator;

public interface AdministratorService {
    public List<Administrator> findAll() throws Exception;
    public Administrator findById(Long id) throws Exception;
    public Administrator save(Administrator admin) throws Exception;
    public Administrator update(Long id, Administrator admin) throws Exception;
    public boolean delete(Long id) throws Exception;
}