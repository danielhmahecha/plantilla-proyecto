package uniandes.edu.co.proyecto.modelo;

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
        private Orden orden_id;

        @ManyToOne
        @JoinColumn (name="bodega_id", referencedColumnName="id")
        private Bodega bodega_id;


        public Recepcion(Integer id, Orden orden_id, Bodega bodega_id)
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

        public Orden getOrdenes_id(){
            return orden_id;
        }

        public Bodega getBodegas_id(){
            return bodega_id;
        }

        public void setId(Integer id){
            this.id = id;
        }

        public void setOrden_id(Orden orden_id){
            this.orden_id = orden_id;
        }

        public void setBodega_id(Bodega bodega_id){
            this.bodega_id = bodega_id;
        }

    }