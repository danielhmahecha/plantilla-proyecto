package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "almacena")
public class Almacena {

    private Integer costo_promedio;
    private Integer capacidad;
    private Integer cantidad;

    @EmbeddedId
    private AlmacenaPK almacenaPK;

    public Almacena(Integer costo_promedio, Integer capacidad, Integer cantidad, AlmacenaPK almacenaPK) {
        this.costo_promedio = costo_promedio;
        this.capacidad = capacidad;
        this.cantidad = cantidad;
        this.almacenaPK = almacenaPK;
    }

    public Almacena() {
        ;
    }

    public Integer getCosto_promedio() {
        return costo_promedio;
    }

    public void setCosto_promedio(Integer costo_promedio) {
        this.costo_promedio = costo_promedio;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public AlmacenaPK getAlmacenaPK() {
        return almacenaPK;
    }

    public void setAlmacenaPK(AlmacenaPK almacenaPK) {
        this.almacenaPK = almacenaPK;
    }

}