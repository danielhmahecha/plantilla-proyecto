package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uniandes.edu.co.proyecto.modelo.Registro;

public interface RegistroRepository extends JpaRepository<Registro, Integer> {
    @Query(value = "SELECT * FROM registro", nativeQuery = true)
    Collection<Registro> darRegistro();
}