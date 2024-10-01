package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    @Query(value = "SELECT * FROM categorias", nativeQuery = true)
    Collection<Categoria> darCategoria();

    @Query(value = "SELECT * FROM categorias WHERE codigo = :codigo", nativeQuery = true)
    Categoria darCategoriaPorCodigo(@Param("codigo") Integer codigo);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO categorias (nombre, descripcion, almacenamiento) VALUES (:nombre, :descripcion, :almacenamiento)", nativeQuery = true)
    void insertarCategoria(@Param("nombre") String nombre, @Param("descripcion") String descripcion,
            @Param("almacenamiento") String almacenamiento);

}