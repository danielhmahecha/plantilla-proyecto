package uniandes.edu.co.proyecto.controller;

import java.sql.Date;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.repositorio.ProductosRepository;

@RestController
public class ProductosController {
    
    @Autowired
    private ProductosRepository productosRepository;

    @GetMapping("/productos")
    public ResponseEntity<Collection<Producto>> Productos(){
        try{
            Collection<Producto> Productos = productosRepository.darProductos();
            return ResponseEntity.ok(Productos);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/productos/new/save")
    public ResponseEntity<?> createProductos(@RequestBody Producto producto){
        try{
            String nombre = producto.getNombre();
            //Integer codigo_de_barras = producto.getCodigo_de_barras();
            Integer precio_unitario = producto.getPrecioUnitario();
            String presentacion = producto.getPresentacion();
            Integer costo_en_bodega = producto.getCostoEnBodega();
            String cantidad_presentacion = producto.getCantidadPresentacion();
            String unidad = producto.getUnidad();
            String empacado = producto.getEmpacado();
            Date expiracion = producto.getExpiracion();
            Integer categoria_codigo = producto.getCategoriaCodigo().getCodigo();

            productosRepository.insertarProductos( nombre, costo_en_bodega, precio_unitario, presentacion, cantidad_presentacion, unidad, empacado, expiracion, categoria_codigo);
            Producto nuevoProductos = productosRepository.darProductosPorNombre(nombre);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProductos);      
        }   catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/productos/{codigo_de_barras}/edit/save")
    public ResponseEntity<?> actualizarProductos(@PathVariable("codigo_de_barras") Integer codigo_de_barras, @RequestBody Producto producto){
        try{
            String nombre = producto.getNombre();
            Integer precio_unitario = producto.getPrecioUnitario();
            Integer costo_en_bodega = producto.getCostoEnBodega();
            String presentacion = producto.getPresentacion();
            String cantidad_presentacion = producto.getCantidadPresentacion();
            String unidad = producto.getUnidad();
            String empacado = producto.getEmpacado();
            Date expiracion = producto.getExpiracion();
            Integer categoria_codigo = producto.getCategoriaCodigo().getCodigo();

            productosRepository.actualizarProductos( codigo_de_barras, nombre, costo_en_bodega, precio_unitario, presentacion, cantidad_presentacion, unidad, empacado, expiracion, categoria_codigo);
            Producto nuevoProductos = productosRepository.darProductosPorCodigo(codigo_de_barras);
            return ResponseEntity.status(HttpStatus.OK).body(nuevoProductos);      
        }   catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping ("/productos/leernombre")
    public ResponseEntity<?> leerProductosNombre(@PathVariable("nombre") String nombre, @RequestBody Producto producto){
        try{
            Producto consultado = productosRepository.darProductosPorNombre(nombre);
            return ResponseEntity.status(HttpStatus.OK).body(consultado);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping ("/productos/leercodigo")
    public ResponseEntity<?> leerProductosCodigo(@PathVariable("codigo_de_barras") Integer codigo_de_barras, @RequestBody Producto producto){
        try{
            Producto consultado = productosRepository.darProductosPorCodigo(codigo_de_barras);
            return ResponseEntity.status(HttpStatus.OK).body(consultado);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
