package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Almacena;

public interface AlmacenaRepository extends JpaRepository<Almacena, Integer> {

    @Query(value = "SELECT * FROM almacena", nativeQuery = true)
    Collection<Almacena> darAlmacena();

    @Query(value = "SELECT * FROM almacena WHERE bodega_id = :bodega_id AND producto_codigo_de_barras =: producto_codigo_de_barras", nativeQuery = true)
    Almacena darAlmacenaPorId(@Param("bodega_id") Integer bodega_id,
            @Param("producto_codigo_de_barras") Integer producto_codigo_de_barras);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO almacena (bodega_id, producto_codigo_de_barras, costo_promedio, capacidad, cantidad) VALUES (:bodega_id, :producto_codigo_de_barras, :costo_promedio, :capacidad, :cantidad)", nativeQuery = true)
    void insertarAlmacena(@Param("bodega_id") Integer bodega_id,
            @Param("producto_codigo_de_barras") Integer producto_codigo_de_barras,
            @Param("costo_promedio") Integer costo_promedio,
            @Param("capacidad") Integer capacidad, @Param("cantidad") Integer cantidad);

    @Modifying
    @Transactional
    @Query(value = "UPDATE almacena SET bodega_id = :bodega_id_actualizado, producto_codigo_de_barras = :producto_codigo_de_barras_actualizado, costo_promedio = :costo_promedio_actualizado, capacidad = :capacidad_actualizado, cantidad = :cantidad_actualizado WHERE bodega_id = :bodega_id AND producto_codigo_de_barras = :producto_codigo_de_barras", nativeQuery = true)
    void actualizarAlmacena(@Param("bodega_id") Integer bodega_id,
            @Param("producto_codigo_de_barras") Integer producto_codigo_de_barras,
            @Param("bodega_id_actualizado") Integer bodega_id_actualizado,
            @Param("producto_codigo_de_barras_actualizado") Integer producto_codigo_de_barras_actualizado,
            @Param("costo_promedio") Integer costo_promedio,
            @Param("costo_promedio_actualizado") Integer costo_promedio_actualizado,
            @Param("capacidad") Integer capacidad,
            @Param("capacidad_actualizado") Integer capacidad_actualizado,
            @Param("cantidad") Integer cantidad,
            @Param("cantidad_actualizado") Integer cantidad_actualizado);

}