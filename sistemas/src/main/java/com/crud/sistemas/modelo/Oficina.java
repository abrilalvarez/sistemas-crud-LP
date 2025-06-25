package com.crud.sistemas.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import java.util.List;

@Entity
@Table(name = "oficinas")
public class Oficina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;

   @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "oficina")
    private List<Sistema> sistemas;

    public void addSistema(Sistema sistema){
        sistemas.add(sistema);
        sistema.setOficina(this);
    }

    // Constructor vacío
    public Oficina() {}

    // Constructor con campos (sin ID)
    public Oficina(String nombre) {
        this.nombre = nombre;
    }

    // Getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Sistema> getSistemas() {
        return sistemas;
    }

    public void setSistemas(List<Sistema> sistemas) {
        this.sistemas = sistemas;
    }
}

