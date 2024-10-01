package uniandes.edu.co.proyecto.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Bodega;
import uniandes.edu.co.proyecto.modelo.Producto;

import java.sql.Date;
import java.util.Collection;

public interface ProductosRepository  extends JpaRepository<Producto, Integer>{

    @Query(value = "SELECT * FROM productos", nativeQuery = true)
    Collection<Producto> darProductos();

    @Query(value = "SELECT * FROM productos WHERE codigo_de_barras = :codigo_de_barras", nativeQuery = true)
    Producto darProductosPorCodigo(@Param("codigo_de_barras") Integer codigo_de_barras);

    @Query(value = "SELECT * FROM productos WHERE nombre = :nombre", nativeQuery = true)
    Producto darProductosPorNombre(@Param("nombre") String nombre);

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

    @Query(value = "SELECT p.*\r\n" + //
            "FROM productos p \r\n" + //
            "LEFT JOIN vende v ON v.producto_codigo_de_barras = p.codigo_de_barras \r\n" + //
            "LEFT JOIN sucursales s ON s.id = v.sucursal_id \r\n" + //
            "LEFT JOIN categorias c ON p.categoria_codigo = c.codigo \r\n" + //
            "WHERE (p.precio_unitario BETWEEN :minPrecio AND :maxPrecio) \r\n" + //
            "AND (p.expiracion > TO_DATE(:fechaLimite1, 'YYYY-MM-DD') OR :fechaLimite1 IS NULL) \r\n" + //
            "AND (p.expiracion < TO_DATE(:fechaLimite2, 'YYYY-MM-DD') OR :fechaLimite2 IS NULL) \r\n" + //
            "AND (s.id = :sucursalId OR :sucursalId IS NULL) \r\n" + //
            "AND (c.nombre = :categoriaNombre OR :categoriaNombre IS NULL)", nativeQuery = true)
    Collection<Producto> buscarProductosFiltrados(@Param("minPrecio") Integer minPrecio,
            @Param("maxPrecio") Integer maxPrecio,
            @Param("fechaLimite1") String fechaLimite1,
            @Param("fechaLimite2") String fechaLimite2,
            @Param("sucursalId") Integer sucursalId,
            @Param("categoriaNombre") String categoriaNombre);
    
            @Query("SELECT new uniandes.edu.co.proyecto.dto.ProductoDTO(" +
            "p.nombre, ib.cantidadActual, ib.cantidadMinima, AVG(cp.costo)) " +
            "FROM Producto p " +
            "JOIN InventarioBodega ib ON p.codigoDeBarras = ib.productoCodigoDeBarras " +
            "JOIN Bodega b ON ib.bodega.id = b.id " +
            "JOIN Sucursal s ON b.sucursal.id = s.id " +
            "JOIN CostoProducto cp ON p.codigoDeBarras = cp.productoCodigoDeBarras " +
            "WHERE s.id = :sucursalId AND b.id = :bodegaId " +
            "GROUP BY p.nombre, ib.cantidadActual, ib.cantidadMinima")
    List<Producto> findProductosBySucursalAndBodega(@Param("sucursalId") Long sucursalId,
            @Param("bodegaId") Long bodegaId);

    @Query(value = "SELECT b.id AS bodegaId, " +
            "SUM(p.volumen) AS volumenOcupado, " +
            "b.capacidad AS capacidadBodega " +
            "FROM bodegas b " +
            "LEFT JOIN productos p ON p.bodega_id = b.id " +
            "GROUP BY b.id, b.capacidad", nativeQuery = true)
    List<Bodega> calcularOcupacionBodegas();

    @Query(value = "SELECT p.nombre AS nombre_producto, p.codigo_de_barras AS id_producto, " +
            "b.nombre AS nombre_bodega, s.nombre AS nombre_sucursal, " +
            "pr.nombre AS nombre_proveedor, ib.cantidadActual AS cantidad_actual " +
            "FROM productos p " +
            "JOIN inventario_bodega ib ON p.codigo_de_barras = ib.producto_codigo_de_barras " +
            "JOIN bodega b ON ib.bodega_id = b.id " +
            "JOIN sucursales s ON b.sucursal_id = s.id " +
            "LEFT JOIN proveedores pr ON pr.id IN (SELECT proveedor_id " +
            "FROM compras c " +
            "WHERE c.producto_codigo_de_barras = p.codigo_de_barras) " +
            "WHERE ib.cantidadActual < ib.cantidadMinimaReorden", nativeQuery = true)
    Collection<Object[]> encontrarProductosQueRequierenOrden();
}