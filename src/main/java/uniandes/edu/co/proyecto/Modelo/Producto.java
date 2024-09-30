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
@Table(name="productos")
public class Producto {
    
        private String nombre;

        @Id 
        @GeneratedValue(strategy= GenerationType.AUTO)
        private Integer codigo_de_barras;

        private Integer costo_en_bodega;

        private Integer precio_unitario;

        private String presentacion;

        private String cantidad_presentacion;

        private String unidad;

        private String empacado;

        private Date expiracion;

        @ManyToOne
        @JoinColumn (name="categoria_codigo", referencedColumnName="codigo")
        private Categoria categoria_codigo;

        public Producto(String nombre, Integer codigo_de_barras, Integer costo_en_bodega, Integer precio_unitario, String presentacion, String cantidad_presentacion, String unidad, String empacado, Date expiracion, Categoria categoria_codigo)
        {
            this.nombre = nombre;
            this.codigo_de_barras = codigo_de_barras;
            this.precio_unitario = precio_unitario;
            this.presentacion = presentacion;
            this.cantidad_presentacion = cantidad_presentacion;
            this.unidad = unidad;
            this.empacado = empacado;
            this.categoria_codigo = categoria_codigo;
            this.expiracion = expiracion;

        }

        public Producto()
        {
            ;

        }

        public String getNombre(){
            return nombre;
        }

        public Integer getCodigo_de_barras(){
            return codigo_de_barras;
        }

        public Integer getCostoEnBodega(){
            return costo_en_bodega;
        }

        public Integer getPrecioUnitario(){
            return precio_unitario;
        }

        public String getPresentacion(){
            return presentacion;
        }

        public String getCantidadPresentacion(){
            return cantidad_presentacion;
        }

        public String getUnidad(){
            return unidad;
        }

        public String getEmpacado(){
            return empacado;
        }

        public Date getExpiracion(){
            return expiracion;
        }

        public Categoria getCategoriaCodigo(){
            return categoria_codigo;
        }

        public void setNombre(String nombre){
            this.nombre = nombre;
        }

        public void setCodigo_de_barras(Integer codigo_de_barras){
            this.codigo_de_barras = codigo_de_barras;
        }

        public void setCostoEnBodega(Integer costo_en_bodega){
            this.costo_en_bodega = costo_en_bodega;
        }

        public void setPrecioUnitario(Integer precio_unitario){
            this.precio_unitario = precio_unitario;
        }

        public void setPresentacion(String presentacion){
            this.presentacion = presentacion;
        }

        public void setCantidadPresentacion(String cantidad_presentacion){
            this.cantidad_presentacion = cantidad_presentacion;
        }

        public void setUnidad(String unidad){
            this.unidad = unidad;
        }

        public void setEmpacado(String empacado){
            this.empacado = empacado;
        }

        public void setExpiracion(Date expiracion){
            this.expiracion = expiracion;
        }

        public void setCategoriaCodigo(Categoria categoria_codigo){
            this.categoria_codigo = categoria_codigo;
        }
        
        }

    