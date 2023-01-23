package com.canislupus.CanisLupus.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class Loggin {
    private Student student;
    private Long idCarrer;
    //private Date beginningP;
}