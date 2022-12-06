package com.canislupus.CanisLupus.Domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.security.authentication.ProviderManager;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
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
public class Kardex_Course extends Padre {
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
}