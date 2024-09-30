package uniandes.edu.co.proyecto.modelo;

import javax.annotation.processing.Generated;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "recepciones")

public class Recepcion {

        @Id 
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;

        @ManyToOne
        @JoinColumn (name="orden_id", referencedColumnName="id")
        private Ordenes orden_id;

        @ManyToOne
        @JoinColumn (name="bodega_id", referencedColumnName="id")
        private Bodegas bodega_id;


        public Recepcion(Integer id, Ordenes orden_id, Bodegas bodega_id)
        {
            this.id = id;
            this.orden_id = orden_id;
            this.bodega_id = bodega_id;

        }
        
        public Recepcion(){
            ;
        }
        
        public Integer getId(){
            return id;
        }

        public Ordenes getOrdenes_id(){
            return orden_id;
        }

        public Bodegas getBodegas_id(){
            return bodega_id;
        }

        public void setId(Integer id){
            this.id = id;
        }

        public void setOrden_id(Ordenes orden_id){
            this.orden_id = orden_id;
        }

        public void setBodega_id(Bodegas bodega_id){
            this.bodega_id = bodega_id;
        }

    }