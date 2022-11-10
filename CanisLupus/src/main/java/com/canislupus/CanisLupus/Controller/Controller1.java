package com.canislupus.CanisLupus.Controller;
import com.canislupus.CanisLupus.Domain.*;
import com.canislupus.CanisLupus.Service.*;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

//@Controller
//CrossOrigin(origins = "*")
//@RestController
//@RequestMapping(path = "cl/admin")
@Slf4j//mandar info al log
public class Controller1 {

    @Autowired
    private AdministratorService adminService;
    @Autowired
    private TutorService tutorService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private KardexService kardexService;

    @GetMapping ("/index/")
    public String inicio(Model model, @AuthenticationPrincipal User user){
       /* var ad = adminService.listarAdministrators();
        // private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LogExample.class);
        log.info("ejecutandose el controller SPRING MVC");
        // log.debug("mas detalle del controlador");
        log.info("usuario iniciando:" + user);
        var u = user.getAuthorities().toArray()[0].toString();
        log.info("USER TYPE: " + u);
        if(u.equalsIgnoreCase("ROLE_ADMINISTRATOR")){
            //ADMINISTRATROS
            System.out.println("*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#\n*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#0000");
            System.out.println("Controlador: imprimiendo lista de ADMINISTRATORS-->\n");
            var admins = adminService.listarAdministrators();
            System.out.println(admins.toString());
            model.addAttribute("administrators", admins);
            model.addAttribute("totalAdministrators", admins.size());
            // //TUTORS
            // System.out.println("*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#\n*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#0000");
            // System.out.println("Controlador: imprimiendo lista de TUTORS-->\n");
            // var tutors = tutorService.listarTutors();
            // System.out.println(tutors.toString());
            // System.out.println("*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#\n*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#0000");
            // model.addAttribute("tutors", tutors);
            // model.addAttribute("totalTutors", tutors.size());
        }
        
        if(u.equals("ROLE_TUTOR")){
            var pupils = studentService.listarPupils();
            var carrers = carrerService.listarCarreras();
            //var ss = subjectSchool.listarSS();
            System.out.println("*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#\n*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#0000");
            System.out.println("Controlador: imprimiendo lista de PUPILS-->\n");
            System.out.println(pupils.toString());
            System.out.println("*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#\n*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#0000");
            model.addAttribute("pupils", pupils);
            model.addAttribute("totalPupils", pupils.size());
            model.addAttribute("carrers", carrers);
        } */
        return "index"; // retorna el nombre de la pagina de inicio
    }

    //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&ADMINISTRATOR´S LINKS&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
    @GetMapping("/cl/admin/agregarAdmin")
    public String agregarAdmin(Administrator admin) {
        return "modificar";//add and update
    }
    /*/
    @PostMapping("/guardar")
    public String guardar (@Valid Administrator admin, Errors errores){//Indicar que el objeto se va validar, el cual se llena en el fomrulario y si hay errores se dbe pasar el parametro para concer el tipo de error
        if (errores.hasErrors()){
            return "modificar";
        }
        adminService.guardar(admin);
        return "redirect:/";
    }
    @GetMapping ("/cl/admin/editar/{id_admi}")
    public String editar(Administrator admin, Model model){
        Administrator aux;
        aux = adminService.encontrarAdmin(admin);
        model.addAttribute("administrator", aux);// mismo nombre que la variable del archivo .html ue recibe el modelo
        return "/administrators/modificar";
    }
    //Segubda manera de pasar varibales en el url queryparameter; ya no es necesario agregar el valor en el path úesto que ya lo incluye el path al hacer queryparamter y este se asocia automaticamente al obbjeto que recibe la funcion
    @GetMapping("/cl/admin/eliminar")//Spring detecta que el atributo id_admi es un atributo del objeto de tipo Administrator y crea el objeto con ese valor
    public String eliminar(Administrator admin){
        adminService.eliminar(admin);
        return "redirect:/cl/";//mal
    }*/
    /*
        @GetMapping("/eliminar/{id_admi}")//Spring detecta que el atributo id_admi es un atributo del objeto de tipo Administrator y crea el objeto con ese valor
        public String eliminar(Administrator admin){
            adminService.eliminar(admin);
            return "redirect:/";
        }*/

        //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&TUTOR´S LINKS&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
    @PostMapping("/cl/admin/guardarTutor")
    public String guardar (@Valid Tutor tutor, Errors errores){//Indicar que el objeto se va validar, el cual se llena en el fomrulario y si hay errores se dbe pasar el parametro para concer el tipo de error
        if (errores.hasErrors()){
            return "modificar";
        }
        tutorService.guardar(tutor);
        return "redirect:/";
    }
    @GetMapping ("/cl/dmin/editarTutor/{id_tutor}")
    public String editar(Tutor tutor, Model model){
        Tutor aux;
        aux = tutorService.encontrarTutor(tutor);
        model.addAttribute("tutor", aux);// mismo nombre que la variable del archivo .html ue recibe el modelo
        return "modificar";
    }

    //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&PUPIL´S LINKS&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
    @PostMapping("/guardarPupil")
    public String guardar (@Valid Student pupil, Errors errores){//Indicar que el objeto se va validar, el cual se llena en el fomrulario y si hay errores se dbe pasar el parametro para concer el tipo de error
        if (errores.hasErrors()){
            System.out.println("sssssssssssssssssssssssssssssss"+pupil.toString()+"sssssssssssssssssssssssssssssss");
            return "tutors/modificarPupil";
        }
        System.out.println("GUARDAR: sssssssssssssssssssssssssssssss"+pupil.toString()+"sssssssssssssssssssssssssssssss");
        studentService.guardar(pupil);
        return "redirect:/";
    } 
    @GetMapping ("/editarPupil/{id_pupil}")
    public String editar(Student pupil, Model model){
        Student aux;
        aux = studentService.encontrarStudent(pupil);
        model.addAttribute("pupil", aux);// mismo nombre que la variable del archivo .html ue recibe el modelo
        return "/tutors/modificarPupil";
    }


     //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&USER´S LINKS&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
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
        studentService.guardar(student);
        kardex.setStudent(student);
        kardexService.guardarKardex(kardex);
        return "/login";
     }
}