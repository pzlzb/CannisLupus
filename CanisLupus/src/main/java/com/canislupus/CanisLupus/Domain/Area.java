package com.canislupus.CanisLupus.Domain;

import java.io.Serializable;

import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name = "areas")
public class Area implements Serializable{

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArea;
    @NotEmpty
    private  String areaName;
}
