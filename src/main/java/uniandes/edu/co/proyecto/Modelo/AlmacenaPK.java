package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class AlmacenaPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "producto_codigo_de_barras", referencedColumnName = "codigo_de_barras")
    private Producto producto_codigo_de_barras;

    @ManyToOne
    @JoinColumn(name = "bodega_id", referencedColumnName = "id")
    private Bodega bodega_id;

    public AlmacenaPK(Producto producto_codigo_de_barras, Bodega bodega_id) {
        super();
        this.producto_codigo_de_barras = producto_codigo_de_barras;
        this.bodega_id = bodega_id;
    }

    public Producto getProductoPorCodigoDeBarras() {
        return producto_codigo_de_barras;
    }

    public void setProductoPorCodigoDeBarras(Producto producto_codigo_de_barras) {
        this.producto_codigo_de_barras = producto_codigo_de_barras;
    }

    public Bodega getId_bodega() {
        return bodega_id;
    }

    public void setId_bodega(Bodega bodega_id) {
        this.bodega_id = bodega_id;
    }

}