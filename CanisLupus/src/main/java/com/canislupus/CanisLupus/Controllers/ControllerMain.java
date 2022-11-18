package com.canislupus.CanisLupus.Controllers;
import com.canislupus.CanisLupus.Domain.*;
import com.canislupus.CanisLupus.Service.*;

import java.sql.Date;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
//CrossOrigin(origins = "*")
//@RestController
//@RequestMapping(path = "cl/")
@Slf4j//mandar info al log
public class ControllerMain {

    @Autowired
    private AdministratorService adminService;
    @Autowired
    private TutorService tutorService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private KardexService kardexService;
    @Autowired
    private CarrerService carrerService;
    

    @GetMapping ("/")
    public String inicio(Model model, @AuthenticationPrincipal User user){
        // private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LogExample.class);
        //log.info("ejecutandose el controller SPRING MVC");
        //log.debug("mas detalle del controlador");
        log.info("Usuario iniciando: " + user);
        var u = user.getAuthorities().toArray()[0].toString();
        log.info("User type:  " + u);

        if(u.equals("ROLE_ADMINISTRATOR")){//ADMINISTRATORS
            System.out.println("*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#\n*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#0000");
            System.out.println("Controlador: imprimiendo lista de ADMINISTRATORS-->\n");
            var admins = adminService.listarAdministrators();
            System.out.println(admins.toString());
            model.addAttribute("administrators", admins);
        }else 

        if(u.equals("ROLE_TUTOR")){//TUTORS
            System.out.println("*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#\n*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#0000");
            System.out.println("Controlador: imprimiendo lista de TUTORS-->\n");
            var tutors = tutorService.listarTutors();
            System.out.println(tutors.toString());
            model.addAttribute("tutors", tutors);
            var students = studentService.listarPupils();
            model.addAttribute("students", students);
        }else

        if(u.equals("ROLE_STUDENT")){
            System.out.println("*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#\n*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#0000");
            System.out.println("Controlador: imprimiendo STUDENT-->\n");
            Student student;
            try {
                student = studentService.encontrarStudent(user.getUsername());
                System.out.println(student.toString());
            } catch (Exception e) {
                student=null;//new Student();
                System.out.println("error, no se encontro username");
            }
            model.addAttribute("students", student);
        }
        return "index"; // retorna el nombre de la pagina de inicio
    }

     @PostMapping("/registry")
     public String registrar(@Valid Student student, @Valid Kardex kardex, Errors errores){
        if(errores.hasErrors()){
            System.out.println("========================VALIDATION-ERRORS REGISTRY========================\n");
            System.out.println("========================\n student:"+ student.toString()+"========================\n");
            System.out.println("========================\n kardex:"+ kardex.toString()+"========================\n");
            return "tutors/modificarStudent";
        }
        System.out.println("========================VALIDATION REGISTRY========================\n");
        System.out.println("========================\n student:"+ student.toString()+"========================\n");
        System.out.println("========================\n kardex:"+ kardex.toString()+"========================\n");
        //studentService.guardar(student);
        kardex.setStudent(student);
        //kardexService.guardarKardex(kardex);
        return "/login";
    }

    @GetMapping("/registry")
    public String registrar(Model model){
        var tutors = tutorService.listarTutors();
        var carrers = carrerService.listarCarreras();
        model.addAttribute("tutors", tutors);
        model.addAttribute("carrers",carrers);
        return "registry";
    }
    
    @GetMapping("/reg")
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(carrerService.listarCarreras());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"error por favor intente más tarde.\"}");
        }
    }
}