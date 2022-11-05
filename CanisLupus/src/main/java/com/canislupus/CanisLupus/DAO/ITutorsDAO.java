package com.canislupus.CanisLupus.DAO;
import com.canislupus.CanisLupus.Domain.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITutorsDAO extends JpaRepository<Tutor, Long> {
    Tutor findBytutorEmail(String tutorEmail);
}
