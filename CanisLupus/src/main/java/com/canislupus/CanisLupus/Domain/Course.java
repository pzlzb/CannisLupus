package com.canislupus.CanisLupus.Domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
//@Audited
@Entity
@Table(name = "courses")
public class Course extends Padre{

    
    @NotEmpty
    private String ssName;
    @NotEmpty
    private Integer credits;

    @NotEmpty
    private Integer maxAttempts;

    @ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "idCarrer")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Carrer idCarrer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idArea")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Area area;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idOptional")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Optionalx optional;

    @ManyToMany( cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Kardex> kardexs = new ArrayList<Kardex>();
}