package com.canislupus.CanisLupus.Controllers;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.canislupus.CanisLupus.Domain.Kardex;
import com.canislupus.CanisLupus.Service.KardexService;

import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(path = "cl/kardex")
public class KardexController {

    @Autowired
    private KardexService kardexService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try {
            System.out.println("CONTROLADOR KARDEX RECIBIENDO DE DATOS DEL SERVICIO: \n"+kardexService.findById(id).toString());
            return ResponseEntity.status(HttpStatus.OK).body(kardexService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"error por favor intente más tarde.\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Kardex kardex){
        try {
                return ResponseEntity.status(HttpStatus.OK).body(kardexService.save(kardex));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"No se pudo guardar el kardex.\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Kardex kardex){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(kardexService.update(kardex));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"No se encontro al kardex (?).\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
                return ResponseEntity.status(HttpStatus.OK).body(kardexService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"No se encontro estudiante.\"}");
        }
    }
}