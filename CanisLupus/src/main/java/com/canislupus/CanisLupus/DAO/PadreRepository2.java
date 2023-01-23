package com.canislupus.CanisLupus.DAO;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PadreRepository2 <E,ID extends Serializable> extends JpaRepository<E,ID>{}