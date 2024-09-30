package uniandes.edu.co.proyecto.repositorio;

import uniandes.edu.co.proyecto.modelo.Provee;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProveeRepository extends JpaRepository<Provee, Integer> {
    @Query(value = "SELECT * FROM provee", nativeQuery = true)
    Collection<Provee> darProvee();
}