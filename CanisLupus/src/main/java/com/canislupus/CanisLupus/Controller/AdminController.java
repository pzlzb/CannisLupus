package com.canislupus.CanisLupus.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
//CrossOrigin(origins = "*")
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
    public ResponseEntity<?> save(@RequestBody Administrator admin){
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
    
}
