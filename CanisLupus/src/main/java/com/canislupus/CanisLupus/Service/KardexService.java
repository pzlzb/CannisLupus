package com.canislupus.CanisLupus.Service;
import com.canislupus.CanisLupus.Domain.Kardex;

public interface KardexService {
    public Kardex findById(Long id) throws Exception;
    public Kardex save(Kardex kardex) throws Exception;
    public Kardex update(Kardex kardex) throws Exception;
    public boolean delete(Long id) throws Exception;
}
