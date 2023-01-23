package com.canislupus.CanisLupus.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.canislupus.CanisLupus.Domain.Kardex_Course2;

@Repository
public interface Kardex_CourseRepository extends PadreRepository2<Kardex_Course2,Long> {
    List<Kardex_Course2> findByGraduateContainingAndKardex(Double graduate,Long id);
}