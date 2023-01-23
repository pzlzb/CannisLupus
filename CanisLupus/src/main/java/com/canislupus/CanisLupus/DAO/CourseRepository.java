package com.canislupus.CanisLupus.DAO;

import org.springframework.stereotype.Repository;

import com.canislupus.CanisLupus.Domain.Course;

@Repository
public interface CourseRepository extends PadreRepository<Course,Long> {
}