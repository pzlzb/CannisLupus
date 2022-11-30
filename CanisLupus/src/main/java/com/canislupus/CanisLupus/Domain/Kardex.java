package com.canislupus.CanisLupus.Domain;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;




// CONTROLADOR KARDEX RECIBIENDO DE DATOS DEL SERVICIO: 
// Kardex [idKardex=1, 
//         student=Student [
//             idStudent=1, 
//             studentName=a, 
//             studentLastName=a, studentEmail=a, 
//             studentPw=a1, 
//             studentidTutor=Tutor(
//                 idTutor=1, 
//                 tutorName=a, 
//                 tutorLastName=a, 
//                 tutorEmail=a, 
//                 tutorPw=a, 
//                 tutorIdUser=Rol(
//                     idUser=1, 
//                     typeUser=a)), 
//                 studentidUser=Rol(
//                     idUser=1, 
//                     typeUser=a)], 
//         begginningP=null, 
//         period=1, 
//         summer=1, 
//         endP=null, 
//         average=1.0, 
//         progress=1.0, 
//         statusStudent=1, 
//         idCarrer=Carrer(
//             idCarrer=1, 
//             carrerName=a, 
//             code=a, 
//             maxTime=1, 
//             minTime=1, 
//             maxCredits=1.0, 
//             minCredits=1.0, 
//             idFaculty=Faculties(
//                 idFaculty=1, 
//                 facultyName=1, 
//                 code=a))]




@Entity(name = "Kardex")
@Table(name = "kardex")//uniqueConstraints = {@UniqueConstraint(columnNames = "matricula")}
public class Kardex implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    private Long idKardex;
   
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idKardex")
    @MapsId// ("idKardex")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Student student;

    // @Temporal(TemporalType.DATE)
    // @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotEmpty
    private Date begginningP;
    @NotEmpty
    private int period;
    @NotEmpty
    private int summer;
    @NotEmpty
    private Date endP;
    @NotEmpty
    private double average;
    @NotEmpty
    private double progress;
    @NotEmpty
    private int statusStudent;
    @ManyToOne
    @JoinColumn( name = "idCarrer")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private  Carrer idCarrer;
    
    @ManyToMany(mappedBy = "kardexs", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Course> courses;

    
    
    public Kardex(Long idKardex, @NotEmpty Date begginningP, @NotEmpty int period, @NotEmpty int summer,
            @NotEmpty Date endP, @NotEmpty double average, @NotEmpty double progress, @NotEmpty int statusStudent,
            Carrer idCarrer, List<Course> courses) {
        this.idKardex = idKardex;
        this.begginningP = begginningP;
        this.period = period;
        this.summer = summer;
        this.endP = endP;
        this.average = average;
        this.progress = progress;
        this.statusStudent = statusStudent;
        this.idCarrer = idCarrer;
        this.courses = courses;
    }

    public Kardex(){}
    
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public Long getIdKardex() {
        return idKardex;
    }
    public void setIdKardex(Long idKardex) {
        this.idKardex = idKardex;
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public Date getBegginningP() {
        return begginningP;
    }
    public void setBegginningP(Date begginningP) {
        this.begginningP = begginningP;
    }
    public int getPeriod() {
        return period;
    }
    public void setPeriod(int period) {
        this.period = period;
    }
    public int getSummer() {
        return summer;
    }
    public void setSummer(int summer) {
        this.summer = summer;
    }
    public Date getEndP() {
        return endP;
    }
    public void setEndP(Date endP) {
        this.endP = endP;
    }
    public double getAverage() {
        return average;
    }
    public void setAverage(double average) {
        this.average = average;
    }
    public double getProgress() {
        return progress;
    }
    public void setProgress(double progress) {
        this.progress = progress;
    }
    public int getStatusStudent() {
        return statusStudent;
    }
    public void setStatusStudent(int statusStudent) {
        this.statusStudent = statusStudent;
    }
    public Carrer getIdCarrer() {
        return idCarrer;
    }
    public void setIdCarrer(Carrer idCarrer) {
        this.idCarrer = idCarrer;
    }
    @Override
    public String toString() {
        return "Kardex [idKardex=" + idKardex + ", student=" + student + ", begginningP=" + begginningP + ", period="
                + period + ", summer=" + summer + ", endP=" + endP + ", average=" + average + ", progress=" + progress
                + ", statusStudent=" + statusStudent + ", idCarrer=" + idCarrer + "]";
    }
    public List<Course> getCourses() {
        return courses;
    }
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}