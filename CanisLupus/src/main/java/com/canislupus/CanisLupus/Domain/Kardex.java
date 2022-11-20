package com.canislupus.CanisLupus.Domain;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "kardex")//uniqueConstraints = {@UniqueConstraint(columnNames = "matricula")}
public class Kardex implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    private Long idKardex;
    @MapsId //("idKardex")
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idKardex")//idkardex es la propiedad que contendra la llave primaria/foranea
    private Student student;

    @NotEmpty
    private Date begginningP;
    @NotEmpty
    private int period;
    @NotEmpty
    private int summer;
    @NotEmpty
    private Date endP;
    @NotEmpty
    private double average;
    @NotEmpty
    private double progress;
    @NotEmpty
    private int statusStudent;
    @ManyToOne
    @JoinColumn( name = "idCarrer")
    private  Carrer idCarrer;  









    /*
     * 
@Data
@Entity
@Table(name = "kardex")//uniqueConstraints = {@UniqueConstraint(columnNames = "matricula")}
public class Kardex implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    private Long idKardex;
    @MapsId //("idKardex")
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idKardex")//idkardex es la propiedad que contendra la llave primaria/foranea
    private Student student;

    @NotEmpty
    private Date begginningP;
    @NotEmpty
    private int period;
    @NotEmpty
    private int summer;
    @NotEmpty
    private Date endP;
    @NotEmpty
    private double average;
    @NotEmpty
    private double progress;
    @NotEmpty
    private int statusStudent;
    @ManyToOne
    @JoinColumn( name = "idCarrer")
    private  Carrer idCarrer;  
     */
    

}