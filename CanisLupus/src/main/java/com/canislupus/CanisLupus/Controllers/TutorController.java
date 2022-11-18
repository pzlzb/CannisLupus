package com.canislupus.CanisLupus.Controllers;

public class TutorController {



    /*
     *     //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&TUTOR´S LINKS&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
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
     */

    
}
