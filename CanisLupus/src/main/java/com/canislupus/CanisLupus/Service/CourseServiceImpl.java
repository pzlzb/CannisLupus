package com.canislupus.CanisLupus.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canislupus.CanisLupus.DAO.CourseRepository;
import com.canislupus.CanisLupus.DAO.PadreRepository;
import com.canislupus.CanisLupus.Domain.Course;

@Service
public class CourseServiceImpl extends PadreServiceImpl<Course,Long> implements CourseService{

    @Autowired
    private CourseRepository courseRepository;

    public CourseServiceImpl(PadreRepository<Course, Long> padreRepository) {super(padreRepository);}

    @Override
    public Course findByUsername(String username) throws Exception {return null;}
}