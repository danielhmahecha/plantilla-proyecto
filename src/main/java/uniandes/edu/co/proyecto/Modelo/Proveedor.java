package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "proveedores")
public class Proveedor {
    
        @Id 
        @GeneratedValue( strategy = GenerationType.AUTO)
        private Integer nit;

        private String nombre;

        private String direccion;

        private String persona_de_contacto;

        private Integer telefono_de_contacto;

        @ManyToOne
        @JoinColumn (name="sucursal_id", referencedColumnName="id")
        private Sucursal sucursal_id;

        public Proveedor(Integer nit, String nombre, String direccion, String persona_de_contacto, Integer telefono_de_contacto, Sucursal sucursal_id)
        {
            super();
            this.sucursal_id = sucursal_id;
            this.nombre = nombre;
            this.direccion = direccion;
            this.persona_de_contacto = persona_de_contacto;
            this.telefono_de_contacto = telefono_de_contacto;
            this.nit = nit;

        }

        public Proveedor ({
            ;
        })

        public Integer getNit(){
            return nit;
        }

        public Sucursal getSucursales_id(){
            return sucursal_id;
        }

        public String getNombre(){
            return nombre;
        }

        public String getDireccion(){
            return direccion;
        }

        public String getPersonaDeContacto(){
            return persona_de_contacto;
        }

        public nit getTelefonoDeContacto(){
            return telefono_de_contacto;
        }

        public void setNit(Integer nit){
            this.nit = nit;
        }

        public void setSucursal_id(Sucursal sucursal_id){
            this.sucursal_id = sucursal_id;
        }

        public void setNombre(String nombre){
            this.nombre = nombre;
        }

        public void setDireccion(String direccion){
            this.direccion = direccion;
        }

        public void setPersonaDeContacto (String persona_de_contacto){
            this.persona_de_contacto = persona_de_contacto;
        }

        public void setTelefonoDeContacto (Integer telefono_de_contacto){
            this.telefono_de_contacto = telefono_de_contacto;
        }

    }