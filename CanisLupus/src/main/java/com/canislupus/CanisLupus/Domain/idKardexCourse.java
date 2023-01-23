package com.canislupus.CanisLupus.Domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Embeddable
public class idKardexCourse implements Serializable{

    @Column(name = "idKardex")
    private Long idKardex;
    @Column(name = "idCourse")
    private Long idCourse;

    // public idKardexCourse(Long idKardex, Long idCourse){
    //     this.idKardex=idKardex;
    //     this.idCourse=idCourse;
    // }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        idKardexCourse that = (idKardexCourse)o;
        return Objects.equals(idKardex, that.idKardex) && Objects.equals(idCourse,that.idCourse);
    }

    @Override
    public int hashCode(){
        return Objects.hash(idKardex, idCourse);
    }
}