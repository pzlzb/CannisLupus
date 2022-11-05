package com.canislupus.CanisLupus.Service;
import java.util.List;
import com.canislupus.CanisLupus.Domain.Administrator;

public interface AdministratorService {
    public List<Administrator> listarAdministrators();
    public void guardar(Administrator admin);
    public void eliminar(Administrator admin);
    public Administrator encontrarAdmin(Administrator admin);
    
}