package com.canislupus.CanisLupus.Domain;
import java.io.Serializable;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
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

    //@OneToMany(mappedBy = "studentidTutor", cascade = CascadeType.ALL)
    //private List<Student> students;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tutorIdUser")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Rol tutorIdUser;

    public Tutor(Long idTutor, @NotEmpty String tutorName, @NotEmpty String tutorLastName, 
                    @NotEmpty String tutorEmail, @NotEmpty String tutorPw,  Rol tutorIdUser) {
        this.idTutor = idTutor;
        this.tutorName = tutorName;
        this.tutorLastName = tutorLastName;
        this.tutorEmail = tutorEmail;
        this.tutorPw = tutorPw;
        this.tutorIdUser = tutorIdUser;
    }
    public Tutor(){}
    
}
 




