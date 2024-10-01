package uniandes.edu.co.proyecto.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Proveedor;

import java.util.Collection;

public interface ProveedoresRepository  extends JpaRepository<Proveedor, Integer>{

    @Query(value = "SELECT * FROM proveedores", nativeQuery = true)
    Collection<Proveedor> darProveedores();

    @Query(value = "SELECT * FROM proveedores WHERE nit = :nit", nativeQuery = true)
    Proveedor darProveedoresPorId(@Param("nit") Integer nit);

    @Modifying
    @Transactional
    @Query(value = "UPDATE proveedores SET nombre = :nombre_actualizado AND direccion = :direccion_actualizado AND persona_de_contacto = :persona_de_contacto_actualizado AND telefono_de_contacto = :telefono_de_contacto_actualizado AND sucursal_id = :sucursal_id_actualizado WHERE nit = :n", nativeQuery = true)
    void actualizarProveedores(@Param("nit") Integer nit, @Param("nombre_actualizado") String nombre_actualizado, @Param("direccion_actualizado") String direccion_actualizado, @Param("persona_de_contacto_actualizado") String persona_de_contacto_actualizado, @Param("telefono_de_contacto_actualizado") Integer telefono_de_contacto_actualizado, @Param("sucursal_id_actualizado") Integer sucursal_id_actualizado);

    @Modifying //preguntarNIT. no la incluyo por como hicimos el sql pero en teoria se deberia ingresar.
    @Transactional
    @Query(value = "INSERT INTO proveedores ( nombre, direccion, persona_de_contacto, telefono_de_contacto, sucursal_id) VALUES ( :nombre, :direccion, :persona_de_contacto, :telefono_de_contacto, ;sucursal_id)", nativeQuery = true)
    void insertarProveedores( @Param("nombre") String nombre, @Param("direccion") String direccion, @Param("persona_de_contacto") String persona_de_contacto, @Param("telefono_de_contacto") Integer telefono_de_contacto, @Param("sucursal_id") Integer sucursal_id);

}