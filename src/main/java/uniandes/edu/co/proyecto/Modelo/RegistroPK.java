package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class RegistroPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "producto_codigo_de_barras", referencedColumnName = "codigo_de_barras")
    private Producto producto_codigo_de_barras;

    @ManyToOne
    @JoinColumn(name = "recepciones_id", referencedColumnName = "id")
    private Recepciones recepciones_id;

    public RegistroPK(Producto producto_codigo_de_barras, Recepciones recepciones_id) {
        super();
        this.producto_codigo_de_barras = producto_codigo_de_barras;
        this.recepciones_id = recepciones_id;
    }

    public Producto getProductos_código_de_barras() {
        return producto_codigo_de_barras;
    }

    public void setProductos_código_de_barras(Producto producto_codigo_de_barras) {
        this.producto_codigo_de_barras = producto_codigo_de_barras;
    }

    public Recepciones getRecepciones_de_productos_id() {
        return recepciones_id;
    }

    public void setRecepciones_de_productos_id(Recepciones recepciones_id) {
        this.recepciones_id = recepciones_id;
    }

}
