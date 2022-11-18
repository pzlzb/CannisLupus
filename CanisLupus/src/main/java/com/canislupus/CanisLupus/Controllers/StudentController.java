package com.canislupus.CanisLupus.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canislupus.CanisLupus.Domain.Student;
import com.canislupus.CanisLupus.Service.StudentService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "cl/student")
public class StudentController {
    
    @Autowired
    private StudentService studentService;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(studentService.listarPupils());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"error por favor intente más tarde.\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(studentService.encontrarStudent(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"error por favor intente más tarde.\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Student student){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(studentService.guardar(student));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"No se pudo guardar al estudiante.\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Student student){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(studentService.actualizarStudent(id, student));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"No se encontro al estudiante (?).\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(studentService.eliminar(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"No se encontro estudiante.\"}");
        }
    }/*
    //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&PUPIL´S LINKS&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
    @PostMapping("/guardarPupil")
    public String guardar (@RequestBody @Valid Student student, Errors errores){//Indicar que el objeto se va validar, el cual se llena en el fomrulario y si hay errores se dbe pasar el parametro para concer el tipo de error
        if (errores.hasErrors()){
            System.out.println("sssssssssssssssssssssssssssssss"+student.toString()+"sssssssssssssssssssssssssssssss");
            return "students/modificarStudent";
        } 
        System.out.println(student.getClass());
        //student.getKardex().setBegginningP();;
        student.getStudentidTutor();
        System.out.println("GUARDAR: sssssssssssssssssssssssssssssss"+student+"sssssssssssssssssssssssssssssss");
        studentService.guardar(student);
        return "redirect:/";
    
    @GetMapping ("/editarPupil/{id_pupil}")
    public String editar(Student pupil, Model model){
        Student aux;
        aux = studentService.encontrarStudent(pupil.getIdStudent());
        model.addAttribute("pupil", aux);// mismo nombre que la variable del archivo .html ue recibe el modelo
        return "/tutors/modificarPupil";
    }
    @GetMapping("/encontrarStudent/{id}")
    public ResponseEntity<?>  encontrarStudent(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(studentService.encontrarStudent(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"error por favor intente más tarde.\"}");
        }
    }
    
    
    
    
    
    */
    
    
}




