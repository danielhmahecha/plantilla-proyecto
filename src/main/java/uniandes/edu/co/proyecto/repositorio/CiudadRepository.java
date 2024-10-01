package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, Integer>
{
    @Query(value = "SELECT * FROM ciudades",nativeQuery = true)
    Collection<Ciudad> darCiudades();

    @Query(value = "SELECT * FROM ciudades WHERE codigo= :codigo",nativeQuery = true)
    Ciudad darCiudad(@Param("codigo") Integer codigo);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ciudades (nombre) VALUES(:nombre)",nativeQuery = true)
    void insertarCiudad(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value="UPDATE ciudades SET nombre = :nombre WHERE codigo = :codigo",nativeQuery = true)
    void actualizarCiudad(@Param("codigo") Integer codigo,@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value="DELETE FROM ciudades WHERE codigo= :codigo",nativeQuery = true)
    void eliminarCiudad(@Param("codigo") Integer codigo);
}