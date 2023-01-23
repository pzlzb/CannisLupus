package com.canislupus.CanisLupus.Domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotEmpty;

import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.ToString;

@NoArgsConstructor
//@AllArgsConstructor
@Data
@ToString
@Entity(name = "Kardex_Course2")
@Table(name = "kardex_course2")
public class Kardex_Course2 implements Serializable {

    @EmbeddedId
    private idKardexCourse id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idCourse")
    @JoinColumn(name = "idCourse")
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idKardex")
    @JoinColumn(name = "idKardex")
    private Kardex kardex;

    public Kardex_Course2(Kardex kardex, Course course){
        this.kardex = kardex;
        this.course = course;
        this.id = new idKardexCourse(kardex.getIdKardex(), course.getId());
    }

    @NotEmpty
    private Double graduate;
    @NotEmpty
    private Integer period;
    @NotEmpty
    private Integer attempts;
    
    // public void addCourse(Course course) {
    //     courses.add(course);
    //     course.getKardexs().add(this);
    // }
 
    // public void removeCourse(Course course) {
    //     courses.remove(course);
    //     course.getKardexs().remove(this);
    // }
     @Override
     public boolean equals(Object o){
         if(this == o) return true;
         if(this == null || getClass() != o.getClass()) return false;
         Kardex_Course2 that = (Kardex_Course2) o;
         return Objects.equals(kardex,that.kardex) &&
                 Objects.equals(course, that.course);
     }
     @Override
     public int hashCode(){
         return Objects.hash(kardex, course);
     }
}