package com.canislupus.CanisLupus.Domain;
import jakarta.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "carrers")
public class Carrer {
    //private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCarrer;
    @NotEmpty
    private String carrerName;
    //@NotEmpty
    private String code;
    //@NotEmpty
    private Integer maxTime;
    //@NotEmpty
    private Integer minTime;
    //@NotEmpty
    private Double maxCredits;
    //@NotEmpty
    private double minCredits;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "idFaculty")
    private Faculties idFaculty;    
}
