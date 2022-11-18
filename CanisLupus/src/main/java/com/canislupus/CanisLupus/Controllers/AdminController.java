package com.canislupus.CanisLupus.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canislupus.CanisLupus.Domain.Administrator;
import com.canislupus.CanisLupus.Service.AdministratorService;

//@Controller
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "cl/admin")
public class AdminController {

    @Autowired
    private AdministratorService adminService;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(adminService.listarAdministrators());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"error por favor intente más tarde.\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(adminService.encontrarAdmin(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"error por favor intente más tarde.\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> guardar(@RequestBody Administrator admin){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(adminService.guardar(admin));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"error por favor intente más tarde.\"}");
        }
    }

    @PutMapping("/{id}")//no funciona aun modificar a query update
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Administrator admin){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(adminService.actualizarAdmin(id, admin));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"error por favor intente más tarde.\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(adminService.eliminar(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"error por favor intente más tarde.\"}");
        }
    }
    /*
    //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&ADMINISTRATOR´S LINKS&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
    @GetMapping("/cl/admin/agregarAdmin")
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
}
