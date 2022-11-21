package com.canislupus.CanisLupus.Domain;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name="users")
public class Rol implements Serializable{
    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    @NotEmpty
    private String typeUser;
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    
    
}