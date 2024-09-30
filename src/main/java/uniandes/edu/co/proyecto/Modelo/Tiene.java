package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tiene")
public class Tiene {
        
        @EmbeddedId
        private TienePK tienePK;
        
        private Integer cantidad;

        private Integer precio;


        public Tiene(TienePK tienePK, Integer cantidad, Integer precio)
        {
            this.tienePK = tienePK;
            this.cantidad = cantidad;
            this.precio = precio;

        }

        public TienePK getTienePK(){
            return tienePK;
        }

        public Integer getCantidad(){
            return cantidad;
        }

        public Integer getPrecio(){
            return precio;
        }

        public void setTienePK(TienePK tienePK){
            this.tienePK = tienePK;
        }

        public void setCantidad(Integer cantidad){
            this.cantidad = cantidad;
        }

        public void setPrecio(Integer precio){
            this.precio = precio;
        }

        }

    