/*package com.canislupus.CanisLupus.Domain;

import jakarta.persistence.*;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity(name = "Kardex_Course")
@Table(name = "kardex_course")
public class Kardex_Course implements Serializable {

    @NotEmpty
    private Double graduate;
    @NotEmpty
    private Integer period;
    @NotEmpty
    private Integer attempts;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idKardex")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Kardex kardex;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "idCourse")
    private Course course;

    //SELECT * FROM kardex_course WHERE idKardex=idKardex;
}*/