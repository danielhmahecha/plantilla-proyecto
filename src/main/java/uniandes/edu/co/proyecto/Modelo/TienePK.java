package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import javax.xml.crypto.Data;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import uniandes.edu.co.proyecto.modelo.Tiene;

@Embeddable
public class TienePK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "producto_codigo_de_barras", referencedColumnName = "codigo_de_barras")
    private Productos producto_codigo_de_barras;

    @ManyToOne
    @JoinColumn(name = "orden_de_compra_id", referencedColumnName = "id")
    private Ordenes orden_de_compra_id;

    public TienePK() {
        super();
        this.producto_codigo_de_barras = producto_codigo_de_barras;
        this.orden_de_compra_id = orden_de_compra_id;

    }

    public Integer getProductoCodigoDeBarras() {
        return producto_codigo_de_barras;
    }

    public Integer getOrdenDeCompraId() {
        return orden_de_compra_id;
    }

    public void setProductoCodigoDeBarras(Integer producto_codigo_de_barras) {
        this.producto_codigo_de_barras = producto_codigo_de_barras;
    }

    public void setOrdenDeCompraId(Integer orden_de_compra_id) {
        this.orden_de_compra_id = orden_de_compra_id;
    }

}
