package com.canislupus.CanisLupus.Domain;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table( name="students", uniqueConstraints = {@UniqueConstraint(columnNames = "studentEmail")                                               })
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStudent;

    // @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    // private Kardex kardex;
    // @OneToOne
    // @JoinColumn(name="idStudent")
    // @MapsId
    // private Kardex kardex;

    @NotEmpty
    private String studentName;
    @NotEmpty
    private String studentLastName;
    @NotEmpty 
    private String studentEmail;
    @NotEmpty
    private String studentPw;
    // @Basic
    // private java.sql.Date beginningP;// @Temporal(TemporalType.DATE)// private Date  beginning;
   
    @ManyToOne
    @JoinColumn(name = "idTutor")
    private Tutor studentidTutor;
    @ManyToOne
    @JoinColumn(name = "idUser")
    private Rol tudentidUser;


//     [
//   {
//     "idStudent": 201772334,
//     "studentName": "Bernardo",
//     "studentLastName": "Perez Lopez",
//     "studentEmail": "bernardo@buap.mx",
//     "studentPw": "$2a$10$EMEndRs0SGUYGp.cE218busas6vZAzN7yPs/XHO1r68ZpP075.d7C",
//     "studentidTutor": {
//       "idTutor": 1,
//       "tutorName": "MARIO",
//       "tutorLastName": "ROSSAINZ LOPEZ",
//       "tutorEmail": "mario@buap.mx",
//       "tutorPw": "$2a$10$EMEndRs0SGUYGp.cE218busas6vZAzN7yPs/XHO1r68ZpP075.d7C",
//       "tutorIdUser": {
//         "idUser": 3,
//         "typeUser": "TUTOR"
//       }
//     },
//     "tudentidUser": {
//       "idUser": 4,
//       "typeUser": "STUDENT"
//     }
//   }
// ]
    
}




 

 



