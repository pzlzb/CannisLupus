package com.canislupus.CanisLupus.Domain;
import java.io.Serializable;
import jakarta.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name="administrators", uniqueConstraints = {@UniqueConstraint(columnNames = "adminEmail")})//especificar el nombre de la tabla en la DB tal cual
public class Administrator implements Serializable{
    private static final long serialVersionUID = 1L;//1 de tipo long
    
    //los nombres deben ser identicos a las columnas de la DB
    @Id//indicar primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto-increment
    private Long idAdmin;
    @NotEmpty
    private String adminName;
    @NotEmpty//no valores vacios ni cadenas vacias, obligatorios
    private String adminLastName;
    @NotEmpty
    @Email
    private String adminEmail;
    @NotEmpty
    private String adminPw;

    @ManyToOne(optional = false, fetch =FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "adminIdUser")
    private Rol adminIdUser;
    //The notation lombok.Data; creates constructors, setters, getters and toString   
    //GUIA https://www.youtube.com/watch?v=T3ohk1cvkVY
}
