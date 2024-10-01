package uniandes.edu.co.proyecto.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Orden;

import java.sql.Date;
import java.util.Collection;

public interface OrdenesRepository  extends JpaRepository<Orden, Integer>{

    @Query(value = "SELECT * FROM ordenes", nativeQuery = true)
    Collection<Orden> darOrdenes();

    @Query(value = "SELECT * FROM ordenes WHERE id = :id, fecha_esperada = :fecha_esperada, estado = :estado, proveedor_nit = :proveedor_nit, sucursal_id = :sucursal_id, cantidad = :cantidad_id, precio = :precio, recepcion_id = :recepcion_id", nativeQuery = true)
    Orden darOrdenesPorId(@Param("id") Integer id);

    @Query(value = "SELECT id FROM ordenes WHERE fecha_esperada = :fecha_esperada, estado = :estado, proveedor_nit = :proveedor_nit, sucursal_id = :sucursal_id, cantidad = :cantidad_id, precio = :precio, recepcion_id = :recepcion_id", nativeQuery = true)
    Orden darOrdenesId(@Param("fecha esperada") Date fecha_esperada, @Param("estado") String estado, @Param("proveedor_nit") Integer proveedor_nit, @Param("sucursal_id") Integer sucursal_id, @Param("cantidad") Integer cantidad, @Param("precio") Integer precio, @Param("recepcion_id") Integer recepcion_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Ordenes SET estado = 'anulada' WHERE id = :id", nativeQuery = true)
    void actualizarOrdenes(@Param("id") Integer id,@Param("fecha esperada") Date fecha_esperada, @Param("proveedor_nit") Integer proveedor_nit, @Param("sucursal_id") Integer sucursal_id, @Param("cantidad") Integer cantidad, @Param("precio") Integer precio, @Param("recepcion_id") Integer recepcion_id);

    @Modifying
    @Transactional //que hacer con recepcion
    @Query(value = "INSERT INTO Ordenes (fecha_esperada, estado, proveedor_nit, sucursal_id, cantidad, precio) VALUES (:fecha_esperada, 'vigente', :proveedor_nit, :sucursal_id, :cantidad, :precio)", nativeQuery = true)
    void insertarOrdenes( @Param("fecha esperada") Date fecha_esperada, @Param("proveedor_nit") Integer proveedor_nit, @Param("sucursal_id") Integer sucursal_id, @Param("cantidad") Integer cantidad, @Param("precio") Integer precio, @Param("recepcion_id") Integer recepcion_id);

}