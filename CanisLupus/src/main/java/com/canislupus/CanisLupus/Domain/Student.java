package com.canislupus.CanisLupus.Domain;
import java.io.Serializable;
import jakarta.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//https://github.com/vladmihalcea
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "Student")
@Table( name="students", uniqueConstraints = {@UniqueConstraint(columnNames = "idStudent"), @UniqueConstraint(columnNames = "studentEmail")})
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="idStudent")
    private Long idStudent;

    // @OneToOne(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)//@LazyToOne(LazyToOneOption.NO_PROXY)
    // @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    // private Kardex kardex;

    @NotEmpty
    private String studentName;
    @NotEmpty
    private String studentLastName;
    @NotEmpty 
    private String studentEmail;
    @NotEmpty
    private String studentPw;
   
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTutor")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Tutor studentidTutor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUser")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private final static Rol idUser = new Rol(4L,"STUDENT");

    public Student( @NotEmpty String studentName, @NotEmpty String studentLastName,
                    @NotEmpty String studentEmail, @NotEmpty String studentPw ) {//Tutor studentidTutor, Rol idUser
        this.studentName = studentName;
        this.studentLastName = studentLastName;
        this.studentEmail = studentEmail;
        this.studentPw = studentPw;
    }
   
    public Long getIdStudent() {
        System.out.println(idStudent+": getIdstudent ");
        System.out.println();
        return idStudent;
    }
    public void setIdStudent(Long idStudent) {
        System.out.println(idStudent+ ": set id student ");
        this.idStudent = idStudent;
    }
    
     // public void setKardex(Kardex kardex) {
    //     if (kardex == null) {
    //         if (this.kardex != null) {
    //             this.kardex.setStudent(null);
    //         }
    //     }
    //     else {
    //         kardex.setStudent(this);
    //     }
    //     this.kardex = kardex;
    // }
    // public Kardex getKardex() {
    //     return kardex;
    // }

    // public void addKardex(Kardex auxKardex){
    //     Kardex.add(auxKardex);
    //     auxKardex.setStudent(this);
    // }

    // public void removeKardex(Kardex auxKardex){
    //     Kardex.remove(auxKardex);
    //     auxKardex.setStudent(null);
    // }
}