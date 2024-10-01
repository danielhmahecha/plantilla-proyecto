package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Vende;

public interface VendeRepository extends JpaRepository<Vende,Integer>
{
    @Query(value = "SELECT * FROM vende", nativeQuery = true)
    Collection<Vende> darVende();

    @Query(value = "SELECT * FROM vende WHERE sucursal_id = :sucursal_id AND producto_codigo_de_barras = :producto_codigo_de_barras", nativeQuery = true)
    Vende darVendePorId(@Param("sucursal_id") Integer sucursal_id, @Param("producto_codigo_de_barras") Integer producto_codigo_de_barras);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM gustan WHERE sucursal_id = :sucursal_id AND producto_codigo_de_barras = :producto_codigo_de_barras", nativeQuery = true)
    void eliminarGustan(@Param("sucursal_id") Integer sucursal_id, @Param("producto_codigo_de_barras") Integer producto_codigo_de_barras);

    @Modifying
    @Transactional
    @Query(value = "UPDATE vende SET sucursal_id = :sucursal_id_actualizado, producto_codigo_de_barras = :producto_codigo_de_barras_actualizado, reorden = :reorden, cantidad = :cantidad WHERE sucursal_id = :sucursal_id AND producto_codigo_de_barras = :producto_codigo_de_barras", nativeQuery = true)
    void actualizarGustan(@Param("sucursal_id") Integer sucursal_id, @Param("producto_codigo_de_barras") Integer producto_codigo_de_barras, @Param("sucursal_id_actualizado") Integer sucursal_id_actualizado, @Param("producto_codigo_de_barras_actualizado") Integer producto_codigo_de_barras_actualizado,@Param("reorden") Integer reorden, @Param("cantidad") Integer cantidad);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO vende (sucursal_id, producto_codigo_de_barras, reorden, cantidad) VALUES (:sucursal_id, :producto_codigo_de_barras, :reorden, :cantidad)", nativeQuery = true)
    void insertarVende(@Param("sucursal_id") Integer sucursal_id, @Param("producto_codigo_de_barras") Integer producto_codigo_de_barras,@Param("reorden") Integer reorden, @Param("cantidad") Integer cantidad);

    @Query(value = "SELECT sucursales.nombre\r\n" +
    "FROM sucursales , vende \r\n" +
    "WHERE sucursales.id = vende.sucursal_id And vende.cantidad >0 and vende.producto_codigo_de_barras = 2", nativeQuery = true)
    Collection<String> darSucursalesPorProducto(@Param("codigo_de_barras") Integer codigo_de_barras);
}