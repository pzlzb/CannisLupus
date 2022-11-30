package com.canislupus.CanisLupus.Domain;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity(name = "Student")
@Table( name="students", uniqueConstraints = {@UniqueConstraint(columnNames = "studentEmail")})
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idStudent")
    private Long idStudent;

    //mappedBy indica el atributo que es dueño de la referencia de la otra tabla
    //@OneToOne(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    //@OneToOne
    //@PrimaryKeyJoinColumn
    //@JoinColumn(name="idStudent")
    //private Kardex kardex;

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
    private Rol studentidUser;

    
    public Student(Long idStudent, @NotEmpty String studentName, @NotEmpty String studentLastName,
            @NotEmpty String studentEmail, @NotEmpty String studentPw, Tutor studentidTutor, Rol studentidUser) {
        this.idStudent = idStudent;
        this.studentName = studentName;
        this.studentLastName = studentLastName;
        this.studentEmail = studentEmail;
        this.studentPw = studentPw;
        this.studentidTutor = studentidTutor;
        this.studentidUser = studentidUser;
    }

    public Student(){}

    // public void setKardex(Kardex kardex) {
    //     if (kardex == null) {
    //         System.out.println("kardex == null " + kardex);
    //         if (this.kardex != null) {
    //             System.out.println("this.kardex != null: "+this.kardex);
    //             this.kardex.setStudent(null);
    //         }
    //     }
    //     else {
    //         System.out.println("else: "+ this);
    //         kardex.setStudent(this);
    //     }
    //     this.kardex = kardex;
    //     System.out.println("##############################################################################################################\n##############################################################################################################");
    //     System.out.println("this-kardex: "+this.kardex);
    // }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public Long getIdStudent() {
        System.out.println(idStudent+": getIdstudent ##############################################################################################################\n##############################################################################################################");
        
        System.out.println();
        return idStudent;
    }
    public void setIdStudent(Long idStudent) {
        System.out.println(idStudent+ ": set id student ##############################################################################################################\n##############################################################################################################");
        this.idStudent = idStudent;
    }
    // public Kardex getKardex() {
    //     return kardex;
    // }
    // public void setKardex(Kardex kardex) {
    //     this.kardex = kardex;
    //     kardex.setStudent(this);
    // }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public String getStudentLastName() {
        return studentLastName;
    }
    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }
    public String getStudentEmail() {
        return studentEmail;
    }
    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }
    public String getStudentPw() {
        return studentPw;
    }
    public void setStudentPw(String studentPw) {
        this.studentPw = studentPw;
    }
    public Tutor getStudentidTutor() {
        return studentidTutor;
    }
    public void setStudentidTutor(Tutor studentidTutor) {
        this.studentidTutor = studentidTutor;
    }
    public Rol getStudentidUser() {
        return studentidUser;
    }
    public void setStudentidUser(Rol studentidUser) {
        this.studentidUser = studentidUser;
    }

    @Override
    public String toString() {
        return "Student [idStudent=" + idStudent + ", studentName=" + studentName
                + ", studentLastName=" + studentLastName + ", studentEmail=" + studentEmail + ", studentPw=" + studentPw
                + ", studentidTutor=" + studentidTutor + ", studentidUser=" + studentidUser + "]";
    }

    

    /*
     * @Data
@Entity
@Table( name="students", uniqueConstraints = {@UniqueConstraint(columnNames = "studentEmail")                                               })
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStudent;

    //mappedBy indica el atributo que es dueño de la referencia de la otra tabla
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    //@JoinColumn(name="idStudent")
    private Kardex kardex;

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
    private Tutor studentidTutor;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUser")
    private Rol tudentidUser;
     */
}




 

 



