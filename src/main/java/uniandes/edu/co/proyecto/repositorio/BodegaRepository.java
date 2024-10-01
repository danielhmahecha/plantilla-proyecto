package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Bodega;

public interface BodegaRepository extends JpaRepository<Bodega, Long>
{
    @Query(value = "SELECT * FROM bodegas",nativeQuery = true)
    Collection<Bodega> darBodegas();

    @Query(value = "SELECT * FROM bodegas WHERE id= :id",nativeQuery = true)
    Bodega darBodega(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO bodegas (nombre,tamaño, sucursal_id) VALUES(:nombre,:tamaño,:sucursal_id)",nativeQuery = true)
    void insertarBodega(@Param("nombre") String nombre,@Param("tamaño") Integer tamaño, @Param("sucursal_id") Integer sucursal_id);

    @Modifying
    @Transactional
    @Query(value="UPDATE bodegas SET nombre = :nombre, tamaño= :tamaño, sucursal_id = :sucursal_id WHERE id = :id",nativeQuery = true)
    void actualizarBodega(@Param("id") Integer id,@Param("nombre") String nombre,@Param("tamaño") Integer tamaño, @Param("sucursal_id") Integer sucursal_id);

    @Modifying
    @Transactional
    @Query(value="DELETE FROM bodegas WHERE id= :id",nativeQuery = true)
    void eliminarBodega(@Param("id") Integer id);
}