package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

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
        private Recepcion recepcion_id;

        public Orden(Integer id, Date fecha_esperada, String estado, Proveedor proveedor_nit, Sucursal sucursal_id, Integer cantidad, Integer precio, Recepcion recepcion_id)
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

        public void setId(Integer id){
            this.id = id;
        }

        public void setFechaEsperada(Date fecha_esperada){
            this.fecha_esperada = fecha_esperada;
        }

        public void setEstado(String estado){
            this.estado = estado;
        }

        public void setProveedor(Proveedor proveedor_nit){
            this.proveedor_nit = proveedor_nit;
        }

        public void setSucursal(Sucursal sucursal_id){
            this.sucursal_id = sucursal_id;
        }

        public void setCantidad(Integer cantidad){
            this.cantidad = cantidad;
        }

        public void setPrecio(Integer precio){
            this.precio = precio;
        }

        public void setRecepcion(Recepcion recepcion_id){
            this.recepcion_id = recepcion_id;
        }
        }

    