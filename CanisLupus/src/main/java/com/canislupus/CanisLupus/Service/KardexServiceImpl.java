package com.canislupus.CanisLupus.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.canislupus.CanisLupus.DAO.IKardexDAO;
import com.canislupus.CanisLupus.Domain.Kardex;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KardexServiceImpl implements KardexService {
    @Autowired
    private IKardexDAO kardexDao;

    @Override
    @Transactional(readOnly = true)
    public Kardex encontrarKardex(Kardex kardex) {
        // TODO Auto-generated method stub
        return kardexDao.findByidKardex((Long)kardex.getStudent().getIdStudent());
    }
    @Override
    @Transactional(readOnly = true)
    public Kardex guardarKardex(Kardex kardex) {
        // TODO Auto-generated method stub
        return kardexDao.save(kardex);
    }
    
}
