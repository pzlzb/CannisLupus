package com.canislupus.CanisLupus.Service;

import java.util.List;

import com.canislupus.CanisLupus.Domain.Carrer;

public interface CarrerService {
    public List<Carrer> listarCarreras();
    public Carrer encontrarCarreras(Long id) throws Exception;
}
