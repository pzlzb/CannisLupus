package com.canislupus.CanisLupus.Domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Embeddable
public class IdKardex implements Serializable{

    @Column(name = "idKardex")
    private Long idKardex;

    @Override
    public boolean equals(Object o){
        if(this == o) return true;//the same object
        if(o == null || getClass() != o.getClass()) return false;//object is null or the object is diferent to the class
        IdKardex that = (IdKardex)o;
        return Objects.equals(idKardex, that.idKardex);
    }

    @Override
    public int hashCode(){
        return Objects.hash(idKardex);
    }
}