package com.canislupus.CanisLupus.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "optionals")
public class Optionalx extends Padre{
    @NotEmpty
    private String name;
}
