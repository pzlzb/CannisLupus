package com.canislupus.CanisLupus.DAO;
import org.springframework.data.jpa.repository.JpaRepository;
import com.canislupus.CanisLupus.Domain.Kardex;

public interface IKardexDAO extends JpaRepository<Kardex,Long>{
    Kardex findByKardex(Kardex kardex);
    Kardex findByidKardex(Long kardex);
}
