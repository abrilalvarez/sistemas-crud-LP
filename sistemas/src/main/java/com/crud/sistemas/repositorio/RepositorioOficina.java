package com.crud.sistemas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.sistemas.modelo.Oficina;

@Repository
public interface RepositorioOficina extends JpaRepository<Oficina, Integer> {
}
