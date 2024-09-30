package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ProveePK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "producto_codigo_de_barras", referencedColumnName = "codigo_de_barras")
    private Producto producto_codigo_de_barras;

    @ManyToOne
    @JoinColumn(name = "proovedor_nit", referencedColumnName = "nit")
    private Proovedor proovedor_nit;

    public ProveePK(Producto producto_codigo_de_barras, Proovedor proovedor_nit) {
        super();
        this.producto_codigo_de_barras = producto_codigo_de_barras;
        this.proovedor_nit = proovedor_nit;
    }

    public Producto getProductoPorCodigoDeBarras() {
        return producto_codigo_de_barras;
    }

    public void setProductoPorCodigoDeBarras(Producto producto_codigo_de_barras) {
        this.producto_codigo_de_barras = producto_codigo_de_barras;
    }

    public Proovedor getProovedor_nit() {
        return proovedor_nit;
    }

    public void setProovedor_nit(Proovedor proovedor_nit) {
        this.proovedor_nit = proovedor_nit;
    }

}
