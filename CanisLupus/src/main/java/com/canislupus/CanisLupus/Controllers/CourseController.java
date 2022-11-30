package com.canislupus.CanisLupus.Controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canislupus.CanisLupus.Domain.Course;
import com.canislupus.CanisLupus.Service.CourseServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "cl/course")
public class CourseController extends PadreControllerImpl <Course,CourseServiceImpl>{   
}