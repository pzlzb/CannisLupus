package com.canislupus.CanisLupus.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import com.canislupus.CanisLupus.Domain.Kardex;
import com.canislupus.CanisLupus.Domain.Student;

public interface IKardexDAO extends JpaRepository<Kardex,Long>{
    Kardex findByidKardex(Long kardex);
}