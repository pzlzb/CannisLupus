package com.canislupus.CanisLupus.Domain;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name= "carrers")
public class Carrer {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCarrer;
    @NotEmpty
    private String carrerName;
    @NotEmpty
    private String code;
    @NotEmpty
    private Integer maxTime;
    @NotEmpty
    private Integer minTime;
    @NotEmpty
    private Double maxCredits;
    @NotEmpty
    private double minCredits;
    @ManyToOne
    @JoinColumn(name = "idFaculty")
    private Faculties idFaculty;    
}
