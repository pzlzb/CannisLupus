package com.canislupus.CanisLupus.Controllers;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.canislupus.CanisLupus.DAO.IKardexDAO;
import com.canislupus.CanisLupus.Domain.Kardex;
import com.canislupus.CanisLupus.Service.KardexService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping(path = "cl/kardex")
public class KardexController {

    @Autowired
    private KardexService kardexService;

    @GetMapping("/{id}")
    public ResponseEntity<?> encontrarKardex(@PathVariable Long id){
        try {
            System.out.println("CONTROLADOR KARDEX RECIBIENDO DE DATOS DEL SERVICIO: \n"+kardexService.encontrarKardex(id).toString());
            return ResponseEntity.status(HttpStatus.OK).body(kardexService.encontrarKardex(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"error por favor intente más tarde.\"}");
        }
    }


    @PostMapping("")
    public ResponseEntity<?> guardarKardex(@RequestBody Kardex kardex){
        try {
                return ResponseEntity.status(HttpStatus.OK).body(kardexService.guardarKardex(kardex));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"No se pudo guardar el kardex.\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizKardex(@PathVariable Long id, @RequestBody Kardex kardex){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(kardexService.actualizKardex(kardex));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"No se encontro al kardex (?).\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarKardex(@PathVariable Long id){
        try {
                return ResponseEntity.status(HttpStatus.OK).body(kardexService.eliminarKardex(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"No se encontro estudiante.\"}");
        }
    }


}
/*
ONTROLADOR KARDEX RECIBIENDO DE DATOS DEL SERVICIO: 
Kardex [idKardex=1, 
            student=Student [idStudent=1, studentName=a, studentLastName=a, studentEmail=a, studentPw=a1, 
            studentidTutor=Tutor(idTutor=1, tutorName=a, tutorLastName=a, tutorEmail=a, tutorPw=a, tutorIdUser=Rol(idUser=1, typeUser=a)),
            studentidUser=Rol(idUser=1, typeUser=a)], begginningP=null, period=1, summer=1, endP=null, average=1.0, progress=1.0, statusStudent=1,
            idCarrer=Carrer(idCarrer=1, carrerName=a, code=a, maxTime=1, minTime=1, maxCredits=1.0, minCredits=1.0,     
            idFaculty=Faculties(idFaculty=1, facultyName=1, code=a))
    ]
     */