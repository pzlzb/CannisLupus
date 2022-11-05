package com.canislupus.CanisLupus.Service;
import java.util.List;
import com.canislupus.CanisLupus.Domain.Tutor;

public interface TutorService {
    public List<Tutor> listarTutors();
    public void guardar(Tutor tutor);
    public void eliminar(Tutor tutor);
    public Tutor encontrarTutor(Tutor tutor);
}
