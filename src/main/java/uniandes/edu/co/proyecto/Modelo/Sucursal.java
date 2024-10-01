package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "sucursales")
public class Sucursal 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String direccion;
    
    private Integer telefono;

    private String nombre;

    @ManyToOne
    @JoinColumn(name="ciudad_codigo",referencedColumnName = "codigo")
    private Ciudad ciudad_codigo;

    public Sucursal(String direccion, Integer telefono,String nombre,Ciudad ciudad_codigo)
    {
        this.direccion=direccion;
        this.telefono=telefono;
        this.nombre=nombre;
        this.ciudad_codigo=ciudad_codigo;
    }

    public Sucursal()
    {
        ;
    }

    public Integer getId() {
        return id;
    }

    public String getDireccion() {
        return direccion;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public Ciudad getCiudad_codigo() {
        return ciudad_codigo;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCiudad_código(Ciudad ciudad_código) {
        this.ciudad_codigo = ciudad_código;
    }

    
}