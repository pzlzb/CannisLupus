package com.canislupus.CanisLupus.Domain;
import jakarta.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name = "faculties")
public class Faculties {
    //private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFaculty;
    @NotEmpty
    private String facultyName;
    @NotEmpty
    private String code;
}
