package com.canislupus.CanisLupus.Domain;
import java.io.Serializable;
import java.time.LocalDate;
import jakarta.persistence.*;
import javax.validation.constraints.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity(name = "Kardex")
@Table(name = "kardex", uniqueConstraints = {@UniqueConstraint(columnNames = "idKardex")})
public class Kardex implements Serializable{
    private static final long serialVersionUID = 1L;
    
    //@EmbeddedId
    //private IdKardex idKardex;
    @Id
    private Long idKardex;
    
   
    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn(name = "student_id", referencedColumnName = "idStudent")
    //@JoinColumn(name="idKardex")
    //@MapsId //("idKardex")
    private Student student;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "DATE default '2023-01-04'")
    @CreatedDate
    private LocalDate begginningP = LocalDate.now();

    @NotNull
    private Integer period =0;
    @NotNull
    private Integer summer=0;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "DATE default '2023-01-04'")
    private LocalDate endP = LocalDate.now();
    
    @NotNull
    private Double average=0D;
    @NotNull
    private Double progress=0D;
    @NotNull
    private Integer statusStudent=1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "idCarrer")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private  Carrer idCarrer;

    // @OneToMany(mappedBy = "kardex",
    //             fetch = FetchType.LAZY,
    //             cascade = CascadeType.ALL,
    //             orphanRemoval = true)
    // @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    // private List<Kardex_Course2> courses = new ArrayList<>();
    
    public Kardex(){}
    public Kardex(Student student, @NotEmpty LocalDate begginningP, @NotEmpty int period, @NotEmpty int summer,
            @NotEmpty LocalDate endP, @NotEmpty double average, @NotEmpty double progress, @NotEmpty int statusStudent) {
        //this.idKardex = new IdKardex(student.getIdStudent());
        this.begginningP = begginningP;
        this.period = period;
        this.summer = summer;
        this.endP = endP;
        this.average = average;
        this.progress = progress;
        this.statusStudent = statusStudent;
    }
    
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Kardex)) return false;
        return idKardex != null && idKardex.equals(((Kardex)o).getIdKardex());
    }

    @Override
    public int hashCode(){
        return getClass().hashCode();
    }   
}