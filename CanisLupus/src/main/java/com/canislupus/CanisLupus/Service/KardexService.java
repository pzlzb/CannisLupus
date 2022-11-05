package com.canislupus.CanisLupus.Service;
import com.canislupus.CanisLupus.Domain.Kardex;

public interface KardexService {
    public Kardex encontrarKardex(Kardex kardex);
    public Kardex guardarKardex(Kardex kardex);
    
}
