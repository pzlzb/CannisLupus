package com.canislupus.CanisLupus.DAO;
import com.canislupus.CanisLupus.Domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

/*Como es una interfaz de tipo generica se debe especificar el tipo de edentidad 
que va a manejar y segun sea la entidad especificar el tipo de identificador
*/
//Para hacer extencion de una interface tambien la clase debe ser una interface, automaticamente spring crea una implementacion de eesta interface

public interface IRolsDAO extends JpaRepository<Rol,Long>{
    Rol findByidUser(String rolEmail);
}