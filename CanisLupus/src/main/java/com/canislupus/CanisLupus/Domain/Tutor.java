package com.canislupus.CanisLupus.Domain;
import java.io.Serializable;
import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

//@Data
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tutorIdUser")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Rol tutorIdUser;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Long getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(Long idTutor) {
        this.idTutor = idTutor;
    }

    public String getTutorName() {
        return tutorName;
    }

    public void setTutorName(String tutorName) {
        this.tutorName = tutorName;
    }

    public String getTutorLastName() {
        return tutorLastName;
    }

    public void setTutorLastName(String tutorLastName) {
        this.tutorLastName = tutorLastName;
    }

    public String getTutorEmail() {
        return tutorEmail;
    }

    public void setTutorEmail(String tutorEmail) {
        this.tutorEmail = tutorEmail;
    }

    public String getTutorPw() {
        return tutorPw;
    }

    public void setTutorPw(String tutorPw) {
        this.tutorPw = tutorPw;
    }

    public Rol getTutorIdUser() {
        return tutorIdUser;
    }

    public void setTutorIdUser(Rol tutorIdUser) {
        this.tutorIdUser = tutorIdUser;
    }

    


}
 




