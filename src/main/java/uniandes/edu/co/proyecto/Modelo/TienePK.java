package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class TienePK implements Serializable {
        
        @ManyToOne
        @JoinColumn (name="producto_codigo_de_barras", referencedColumnName="codigo_de_barras")
        private Producto producto_codigo_de_barras;  
        
        @ManyToOne
        @JoinColumn (name="orden_de_compra_id", referencedColumnName="id")
        private Orden orden_de_compra_id;   

        public TienePK(Producto producto_codigo_de_barras, Orden orden_de_compra_id)
        {
            super();
            this.producto_codigo_de_barras = producto_codigo_de_barras;
            this.orden_de_compra_id = orden_de_compra_id;

    @ManyToOne
    @JoinColumn(name = "orden_de_compra_id", referencedColumnName = "id")
    private Orden orden_de_compra_id;

    public TienePK() {
        super();
        this.producto_codigo_de_barras = producto_codigo_de_barras;
        this.orden_de_compra_id = orden_de_compra_id;

        public Producto getProductoCodigoDeBarras(){
            return producto_codigo_de_barras;
        }

        public Orden getOrdenDeCompraId(){
            return orden_de_compra_id;
        }

        public void setProductoCodigoDeBarras(Producto producto_codigo_de_barras){
            this.producto_codigo_de_barras = producto_codigo_de_barras;
        }

        public void setOrdenDeCompraId(Orden orden_de_compra_id){
            this.orden_de_compra_id = orden_de_compra_id;
        }

    public void setOrdenDeCompraId(Integer orden_de_compra_id) {
        this.orden_de_compra_id = orden_de_compra_id;
    }

}
