package uniandes.edu.co.proyecto.modelo;

import java.lang.annotation.Inherited;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "ordenes")
public class Orden {
    
        @Id 
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;

        private Date fecha_esperada;

        private String estado;

        @ManyToOne
        @JoinColumn (name="proveedor_nit", referencedColumnName="nit")
        private Proveedor proveedor_nit;

        @ManyToOne
        @JoinColumn (name="sucursal_id", referencedColumnName="id")
        private Sucursal sucursal_id;

        private Integer cantidad;

        private Integer precio;

        @ManyToOne
        @JoinColumn (name="recepcion_id", referencedColumnName="id")
        private Recepciones recepcion_id;

        public Ordenes(Integer id, Date fecha_esperada, String estado, Proveedor proveedor_nit, Sucursal sucursal_id, Integer cantidad, Integer precio, Recepcion recepcion_id)
        {
            this.id = id;
            this.fecha_esperada = fecha_esperada;
            this.estado = estado;
            this.proveedor_nit = proveedor_nit;
            this.sucursal_id = sucursal_id;
            this.cantidad = cantidad;
            this.precio = precio;
            this.recepcion_id = recepcion_id;

        }

        public Integer getId(){
            return id;
        }

        public Date getFechaEsperada(){
            return fecha_esperada;
        }

        public String getEstado(){
            return estado;
        }

        public Proveedor getProveedor(){
            return proveedor_nit;
        }

        public Sucursal getSucursal(){
            return sucursal_id;
        }

        public Integer getCantidad(){
            return cantidad;
        }

        public Integer getPrecio(){
            return precio;
        }

        public Recepcion getRecepcion(){
            return recepcion_id;
        }

        public voit setId(){
            this.id = id;
        }

        public void setFechaEsperada(){
            this.fecha_esperada = fecha_esperada;
        }

        public void setEstado(){
            this.estado = estado;
        }

        public void setProveedor(){
            this.proveedor_nit = proveedor_nit;
        }

        public void setSucursal(){
            this.sucursal_id = sucursal_id;
        }

        public void setCantidad(){
            this.cantidad = cantidad;
        }

        public void setPrecio(){
            this.precio = precio;
        }

        public void setRecepcion(){
            this.recepcion_id = recepcion_id;
        }
        }

    