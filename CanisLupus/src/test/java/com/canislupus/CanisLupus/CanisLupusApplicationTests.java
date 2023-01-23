package com.canislupus.CanisLupus;

import jakarta.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.canislupus.CanisLupus.Domain.Carrer;
import com.canislupus.CanisLupus.Domain.Kardex;
import com.canislupus.CanisLupus.Domain.Rol;
import com.canislupus.CanisLupus.Domain.Student;
import com.canislupus.CanisLupus.Service.CarrerService;
import com.canislupus.CanisLupus.Service.KardexService;
import com.canislupus.CanisLupus.Service.RolService;
import com.canislupus.CanisLupus.Service.StudentService;
import com.canislupus.CanisLupus.Service.TutorService;

@SpringBootTest
class CanisLupusApplicationTests {
	@Autowired
	private StudentService studentService;
	@Autowired
	private KardexService kardexService;
	@Autowired
	private TutorService tutorService;
	@Autowired
	private RolService rolService;
	@Autowired
	private CarrerService carrerService;

	@Test
	void contextLoads() {

		var tutor = tutorService.encontrarTutor(1L);
		Rol rol = rolService.encontrarRol(4L);
		Student student =  new Student();
		student.setIdStudent(88888888888L);
		student.setStudentName("berni");
		student.setStudentLastName("pl");
		student.setStudentEmail("ber85ni@buap.mx");
		student.setStudentPw("123");
		student.setStudentidTutor(tutor);
		//student.setidUser(rol);

		// Kardex kardex = new Kardex();
		// Carrer carrer = new Carrer();
		// try {
		// 	Student student1 = studentService.save(student);
		// 	carrer = carrerService.encontrarCarreras(3L);
		// 	kardex.setIdCarrer(carrer);
		// 	kardex.setIdKardex(student1.getIdStudent());
		// 	kardexService.save(kardex);
		// } catch (Exception e) {
		// 	new Exception(e.getMessage());
		// }
	}
}
