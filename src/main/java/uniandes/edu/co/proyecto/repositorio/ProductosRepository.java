package uniandes.edu.co.proyecto.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Productos;

import java.sql.Date;
import java.util.Collection;

public interface ProductosRepository  extends JpaRepository<Productos, Integer>{

    @Query(value = "SELECT * FROM productos", nativeQuery = true)
    Collection<Productos> darProductos();

    @Query(value = "SELECT * FROM productos WHERE codigo_de_barras = :codigo_de_barras", nativeQuery = true)
    Productos darProductosPorCodigo(@Param("codigo_de_barras") Integer codigo_de_barras);

    @Query(value = "SELECT * FROM productos WHERE nombre = :nombre", nativeQuery = true)
    Productos darProductosPorNombre(@Param("nombre") Integer nombre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE productos SET nombre = :nombre_actualizado, costo_en_bodega = :costo_en_bodega_actualizado, precio_unitario = :precio_unitario_actualizado, presentacion = :presentacion_actualizado, cantidad_presentacion = :cantidad_presentacion_actualizado, unidad = :unidad_actualizado, empacado = :empacado_actualizado, expiracion =:expiracion_actualizado, categoria_codigo =: categoria_codigo_actualizado WHERE codigo_de_barras = :codigo_de_barras", nativeQuery = true)
    void actualizarProductos(@Param("codigo_de_barras") Integer codigo_de_barras, @Param("nombre_actualizado") String nombre_actualizado, @Param("costo_en_bodega_actualizado") Integer costo_en_bodega_actualizado, @Param("precio_unitario_actualizado") Integer precio_unitario_actualizado, @Param("presentacion_actualizado") String presentacion_actualizado, @Param("cantidad_presentacion_actualizado") String cantidad_presentacion_actualizado, @Param("unidad_actualizado") String unidad_actualizado, @Param("empacado_actualizado") String empacado_actualizado, @Param("expiracion_actualizado") Date expiracion_actualizado, @Param("categoria_codigo_actualizado") Integer categoria_codigo_actualizado);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO productos ( nombre, costo_en_bodega, precio_unitario, presentacion, cantidad_presentacion, unidad, empacado, expiracion, categoria_codigo) VALUES (:nombre,  :costo_en_bodega,  :precio_unitario,  :presentacion,  :cantidad_presentacion, :unidad,  :empacado, :expiracion, :categoria_codigo)", nativeQuery = true)
    void insertarProductos(@Param("nombre") String nombre, @Param("costo_en_bodega") Integer costo_en_bodega, @Param("precio_unitario") Integer precio_unitario, @Param("presentacion") String presentacion, @Param("cantidad_presentacion") String cantidad_presentacion, @Param("unidad") String unidad, @Param("empacado") String empacado, @Param("expiracion") Date expiracion, @Param("categoria_codigo") Integer categoria_codigo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM productos WHERE codigo_de_barras = :codigo_de_barras",nativeQuery = true)
    void eliminarProductos(@Param("codigo_de_barras") Integer codigo_de_barras);
 
}