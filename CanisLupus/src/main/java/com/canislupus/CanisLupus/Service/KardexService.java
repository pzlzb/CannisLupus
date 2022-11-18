package com.canislupus.CanisLupus.Service;
import com.canislupus.CanisLupus.Domain.Kardex;

public interface KardexService {
    public Kardex encontrarKardex(Long id) throws Exception;
    public Kardex guardarKardex(Kardex kardex) throws Exception;
    public Kardex actualizKardex(Kardex kardex) throws Exception;
    public boolean eliminarKardex(Long id) throws Exception;
}
