package com.canislupus.CanisLupus.Domain;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
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
    @Column(columnDefinition = "DATE default '2023-01-04'")
    @NotNull
    private Date begginningP;
    @NotNull
    private int period;
    @NotNull
    private int summer;
    @NotNull
    private Date endP;
    @NotNull
    private double average;
    @NotNull
    private double progress;

    @NotNull
    private int statusStudent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "idCarrer")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private  Carrer idCarrer;

    @OneToMany(mappedBy = "kardex", fetch = FetchType.LAZY)
    //@JoinColumn( name = "kardex_course")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Kardex_Course> kardex_Course;

    // public Kardex(Long idKardex, @NotEmpty Date begginningP, @NotEmpty int period, @NotEmpty int summer,
    //         @NotEmpty Date endP, @NotEmpty double average, @NotEmpty double progress, @NotEmpty int statusStudent,
    //         Carrer idCarrer, List<Course> courses) {
    //     this.idKardex = idKardex;
    //     this.begginningP = begginningP;
    //     this.period = period;
    //     this.summer = summer;
    //     this.endP = endP;
    //     this.average = average;
    //     this.progress = progress;
    //     this.statusStudent = statusStudent;
    //     this.idCarrer = idCarrer;
    // }

    // public Kardex(){}
    
    // public static long getSerialversionuid() {
    //     return serialVersionUID;
    // }
    // public Long getIdKardex() {
    //     return idKardex;
    // }
    // public void setIdKardex(Long idKardex) {
    //     this.idKardex = idKardex;
    // }
    // public Student getStudent() {
    //     return student;
    // }
    // public void setStudent(Student student) {
    //     this.student = student;
    // }
    // public Date getBegginningP() {
    //     return begginningP;
    // }
    // public void setBegginningP(Date begginningP) {
    //     this.begginningP = begginningP;
    // }
    // public int getPeriod() {
    //     return period;
    // }
    // public void setPeriod(int period) {
    //     this.period = period;
    // }
    // public int getSummer() {
    //     return summer;
    // }
    // public void setSummer(int summer) {
    //     this.summer = summer;
    // }
    // public Date getEndP() {
    //     return endP;
    // }
    // public void setEndP(Date endP) {
    //     this.endP = endP;
    // }
    // public double getAverage() {
    //     return average;
    // }
    // public void setAverage(double average) {
    //     this.average = average;
    // }
    // public double getProgress() {
    //     return progress;
    // }
    // public void setProgress(double progress) {
    //     this.progress = progress;
    // }
    // public int getStatusStudent() {
    //     return statusStudent;
    // }
    // public void setStatusStudent(int statusStudent) {
    //     this.statusStudent = statusStudent;
    // }
    // public Carrer getIdCarrer() {
    //     return idCarrer;
    // }
    // public void setIdCarrer(Carrer idCarrer) {
    //     this.idCarrer = idCarrer;
    // }
}