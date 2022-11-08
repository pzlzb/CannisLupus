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


    public void setKardex(Kardex kardex){
        this.kardex=kardex;
        kardex.setStudent(this);
    }
    public Kardex getKardex(){
        return kardex;
    }
}




 

 



