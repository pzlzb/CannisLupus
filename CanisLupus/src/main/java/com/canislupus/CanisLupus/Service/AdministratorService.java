package com.canislupus.CanisLupus.Service;
import java.util.List;
import com.canislupus.CanisLupus.Domain.Administrator;

public interface AdministratorService {
    public List<Administrator> listarAdministrators() throws Exception;
    public Administrator guardar(Administrator admin) throws Exception;
    public boolean eliminar(Long id) throws Exception;
    public Administrator encontrarAdmin(Long id) throws Exception;
    public Administrator actualizarAdmin(Long id, Administrator admin) throws Exception;
}