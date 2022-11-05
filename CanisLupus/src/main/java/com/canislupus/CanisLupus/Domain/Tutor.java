package com.canislupus.CanisLupus.Domain;
import java.io.Serializable;
import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name="tutors", uniqueConstraints = {@UniqueConstraint(columnNames = "tutorEmail")})
public class Tutor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTutor;
    @NotEmpty
    private String tutorName;
    @NotEmpty
    private String tutorLastName;
    @NotEmpty 
    private String tutorEmail;
    @NotEmpty
    private String tutorPw;
    @ManyToOne
    @JoinColumn(name="tutorIdUser")
    private Rol tutorIdUser;
}
 




