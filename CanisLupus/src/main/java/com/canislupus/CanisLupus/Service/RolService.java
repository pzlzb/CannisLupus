package com.canislupus.CanisLupus.Service;
import java.util.List;
import com.canislupus.CanisLupus.Domain.Rol;

public interface RolService {
    public List<Rol> listarRols();
    public void guardar(Rol rol);
    public void eliminar(Rol rol);
    public Rol encontrarRol(Long id);   
}