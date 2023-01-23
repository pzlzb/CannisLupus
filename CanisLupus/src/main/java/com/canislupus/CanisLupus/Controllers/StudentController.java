package com.canislupus.CanisLupus.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.canislupus.CanisLupus.Domain.Kardex_Course2;
import com.canislupus.CanisLupus.Domain.Student;
import com.canislupus.CanisLupus.Service.StudentService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "cl/student")
public class StudentController {
    
    @Autowired
    private StudentService studentService;

    @GetMapping(value = "")
    public ResponseEntity<?> getAll(){
        try {
            System.out.println("CONTROLADOR STUDENT RECIBIENDO DE DATOS DEL SERVICIO: \n" + studentService.findAll());
            return ResponseEntity.status(HttpStatus.OK).body(studentService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"error por favor intente más tarde.\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try {
            System.out.println("CONTROLADOR STUDENT RECIBIENDO DE DATOS DEL SERVICIO: \n" + studentService.findById(id));
            return ResponseEntity.status(HttpStatus.OK).body(studentService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"error por favor intente más tarde.\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Student student){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(studentService.save(student));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"No se pudo guardar al estudiante.\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Student student){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(studentService.update(id, student));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"No se encontro al estudiante (?).\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(studentService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"No se encontro estudiante.\"}");
        }
    }

    @GetMapping("/reprobadas/{id}")
    public ResponseEntity<?> seeReprobadas(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(studentService.verReprobadas(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"No se encontro estudiante.\"}");
        }
        //validadciones
        //1) existe el alumno pero no tiene reprobadas
        //2) No existe el alumno
        // 3) existe el alumno pero no el kardex
        //4) existe el kardex pero no el aluno
    }
}