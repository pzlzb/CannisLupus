package com.canislupus.CanisLupus.DAO;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.canislupus.CanisLupus.Domain.Padre;

@NoRepositoryBean//no se crean instancaias de esta interfaz
//E (tipode identidad) y esta etidad de debe de extender de Base para que no se pueda utilizar tipos que no extiendan de base
//ID TIPO DE ID que tiene la entidad
//la interface extiende JPAREPOSITORY y esa clase extuende de E,ID
public interface PadreRepository <E extends Padre, ID extends Serializable> extends JpaRepository<E, ID>{}