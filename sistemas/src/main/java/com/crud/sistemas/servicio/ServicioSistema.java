package com.crud.sistemas.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crud.sistemas.modelo.Sistema;
import com.crud.sistemas.repositorio.RepositorioSistema;

@Service
public class ServicioSistema implements ServicioSistemaInterface {

    @Autowired
    private RepositorioSistema repositorioSistema;

    @Override
    public List<Sistema> listar() {
        return repositorioSistema.findAll();
    }

    @Override
    public Sistema findById(int id) {
        return repositorioSistema.findById(id).orElse(null);
    }

    @Override
    public Sistema save(Sistema sistema) {
        return repositorioSistema.save(sistema);
    }

    @Override
    public void deleteById(int id) {
        repositorioSistema.deleteById(id);
    }
    
}
