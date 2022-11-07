package com.canislupus.CanisLupus.Domain;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table( name="students", uniqueConstraints = {@UniqueConstraint(columnNames = "studentEmail")                                               })
public class Student {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStudent;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    //@PrimaryKeyJoinColumn
    private Kardex kardex;

    @NotEmpty
    private String studentName;
    @NotEmpty
    private String studentLastName;
    @NotEmpty 
    private String studentEmail;
    @NotEmpty
    private String studentPw;    
    @Basic
    private java.sql.Date beginning;// @Temporal(TemporalType.DATE)// private Date  beginning;
   
    @ManyToOne
    @JoinColumn(name = "studentIdTutor")
    private Tutor studentidTutor;
    @ManyToOne
    @JoinColumn(name = "studentIdUser")
    private Rol studentidUser;
    public Student(@NotEmpty String studentName, @NotEmpty String studentLastName, @NotEmpty String studentEmail,
            @NotEmpty String studentPw, java.sql.Date beginning, Tutor studentidTutor, Rol studentidUser) {
        this.studentName = studentName;
        this.studentLastName = studentLastName;
        this.studentEmail = studentEmail;
        this.studentPw = studentPw;
        this.beginning = beginning;
        this.studentidTutor = studentidTutor;
        this.studentidUser = studentidUser;
    }
   

   
}  
 

 



