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
import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j//mandar info al log
public class Controller1 {

    @Autowired
    private AdministratorService adminService;
    @Autowired
    private TutorService tutorService;
  

    @GetMapping ("/")
    public String inicio(Model model, @AuthenticationPrincipal User user){
        var ad = adminService.listarAdministrators();
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
        /*
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
    @GetMapping("/agregarAdmin")
    public String agregarAdmin(Administrator admin) {
        return "modificar";//add and update
    }
    @PostMapping("/guardar")
    public String guardar (@Valid Administrator admin, Errors errores){//Indicar que el objeto se va validar, el cual se llena en el fomrulario y si hay errores se dbe pasar el parametro para concer el tipo de error
        if (errores.hasErrors()){
            return "modificar";
        }
        adminService.guardar(admin);
        return "redirect:/";
    }
    @GetMapping ("/editar/{id_admi}")
    public String editar(Administrator admin, Model model){
        Administrator aux;
        aux = adminService.encontrarAdmin(admin);
        model.addAttribute("administrator", aux);// mismo nombre que la variable del archivo .html ue recibe el modelo
        return "/administrators/modificar";
    }
    //Segubda manera de pasar varibales en el url queryparameter; ya no es necesario agregar el valor en el path úesto que ya lo incluye el path al hacer queryparamter y este se asocia automaticamente al obbjeto que recibe la funcion
    @GetMapping("/eliminar")//Spring detecta que el atributo id_admi es un atributo del objeto de tipo Administrator y crea el objeto con ese valor
    public String eliminar(Administrator admin){
        adminService.eliminar(admin);
        return "redirect:/";
    }
    /*
        @GetMapping("/eliminar/{id_admi}")//Spring detecta que el atributo id_admi es un atributo del objeto de tipo Administrator y crea el objeto con ese valor
        public String eliminar(Administrator admin){
            adminService.eliminar(admin);
            return "redirect:/";
        }*/

        //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&TUTOR´S LINKS&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
    @PostMapping("/guardarTutor")
    public String guardar (@Valid Tutor tutor, Errors errores){//Indicar que el objeto se va validar, el cual se llena en el fomrulario y si hay errores se dbe pasar el parametro para concer el tipo de error
        if (errores.hasErrors()){
            return "modificar";
        }
        tutorService.guardar(tutor);
        return "redirect:/";
    }
    @GetMapping ("/editarTutor/{id_tutor}")
    public String editar(Tutor tutor, Model model){
        Tutor aux;
        aux = tutorService.encontrarTutor(tutor);
        model.addAttribute("tutor", aux);// mismo nombre que la variable del archivo .html ue recibe el modelo
        return "modificar";
    }

    //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&PUPIL´S LINKS&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

     //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&USER´S LINKS&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

}



   
