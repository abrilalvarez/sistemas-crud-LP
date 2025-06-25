package com.crud.sistemas.servicio;

import java.util.List;
import com.crud.sistemas.modelo.Sistema;

public interface ServicioSistemaInterface {
    public List<Sistema> listar();
    public Sistema findById(int id);
    public Sistema save(Sistema sistema);
    public void deleteById(int id);
}
