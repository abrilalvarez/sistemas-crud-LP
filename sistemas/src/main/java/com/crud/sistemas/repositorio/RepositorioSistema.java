package com.crud.sistemas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.sistemas.modelo.Sistema;

@Repository
public interface RepositorioSistema extends JpaRepository<Sistema, Integer> {
}


