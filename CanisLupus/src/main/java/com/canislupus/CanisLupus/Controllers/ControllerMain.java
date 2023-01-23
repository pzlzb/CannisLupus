package com.canislupus.CanisLupus.Controllers;
import com.canislupus.CanisLupus.Domain.*;
import com.canislupus.CanisLupus.Service.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
    @Autowired
    private RolService rolService;
    
    

    @GetMapping ("/")
    public String inicio(Model model, @AuthenticationPrincipal User user) throws Exception{
        // private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LogExample.class);
        //log.info("ejecutandose el controller SPRING MVC");
        //log.debug("mas detalle del controlador");
        log.info("Usuario iniciando: " + user);
        var u = user.getAuthorities().toArray()[0].toString();
        log.info("User type:  " + u);

        if(u.equals("ROLE_ADMINISTRATOR")){//ADMINISTRATORS
            System.out.println("*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#\n*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#0000");
            System.out.println("Controlador: imprimiendo lista de ADMINISTRATORS-->\n");
            var admins = adminService.findAll();
            System.out.println(admins.toString());
            model.addAttribute("administrators", admins);
        }else 

        if(u.equals("ROLE_TUTOR")){//TUTORS
            System.out.println("*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#\n*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#0000");
            System.out.println("Controlador: imprimiendo lista de TUTORS-->\n");
            var tutors = tutorService.listarTutors();
            System.out.println(tutors.toString());
            model.addAttribute("tutors", tutors);
            var students = studentService.findAll();
            model.addAttribute("students", students);
        }else

        if(u.equals("ROLE_STUDENT")){
            System.out.println("*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#\n*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#0000");
            System.out.println("Controlador: imprimiendo STUDENT-->\n");
            Student student;
            try {
                student = studentService.findByUsername(user.getUsername());
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
     public String registrar( @Valid Student student, Long idcarrer, Errors errores) throws Exception{//@Valid Student student
        Student savedStudent =  new Student();
        System.out.println("id carrer"+idcarrer);
        if(errores.hasErrors()){
            System.out.println("===VALIDATION-ERRORS REGISTRY===");
            System.out.println("===\n student:"+ student.toString()+"===");
            return "tutors/modificarStudent";
        }else{
            System.out.println("===VALIDATION REGISTRY===\n");
            System.out.println("===\n"+ student.toString()+"\n===");
            try {
                savedStudent = studentService.save(student);
            } catch (Exception e) {
                new Exception(e.getMessage());
            }
            Kardex kardex = new Kardex();
            Kardex savedKardex = new Kardex();
            Carrer carrer = new Carrer();
            try {
                //savedStudent = studentService.findById(student.getIdStudent());
                System.out.println(savedStudent);
                carrer = carrerService.encontrarCarreras(idcarrer);
                System.out.println(carrer);
                kardex.setIdCarrer(carrer);
                System.out.println(kardex);
                kardex.setIdKardex(savedStudent.getIdStudent());
                System.out.println(kardex);
                kardex.setStudent(savedStudent);
                System.out.println(kardex);
                savedKardex = kardexService.save(kardex);
            } catch (Exception e) {
                new Exception(e.getMessage());
            }
        }
        return "redirect:/login";
    }

    @GetMapping("/registry")
    public String registrar(Model model){
        var tutors = tutorService.listarTutors();
        var carrers = carrerService.listarCarreras();
        var users = rolService.encontrarRol(4L);
        var kardex = new Kardex();
        var student = new Student();
        model.addAttribute("tutors", tutors);
        model.addAttribute("carrers",carrers);
        model.addAttribute("users", users);
        return "registry";
    }
}