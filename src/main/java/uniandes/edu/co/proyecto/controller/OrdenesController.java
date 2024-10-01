package uniandes.edu.co.proyecto.controller;

import java.sql.Date;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import uniandes.edu.co.proyecto.modelo.Orden;
//import uniandes.edu.co.proyecto.modelo.OrdenPK;
import uniandes.edu.co.proyecto.repositorio.OrdenesRepository;

@RestController
public class OrdenesController {
    
    @Autowired
    private OrdenesRepository ordenesRepository;

    @GetMapping("/Ordenes")
    public ResponseEntity<Collection<Orden>> Ordenes(){
        try{
            Collection<Orden> Ordenes = ordenesRepository.darOrdenes();
            return ResponseEntity.ok(Ordenes);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/Ordenes/new/save")
    public ResponseEntity<?> createOrdenes(@RequestBody Orden orden){
        try{
            Integer id = orden.getId();
            Date fecha_esperada = orden.getFechaEsperada();
            Integer proveedores_nit = orden.getProveedor().getNit();
            Integer sucursales_id = orden.getSucursal().getId();
            Integer cantidad = orden.getCantidad();
            Integer precio = orden.getPrecio();
            Integer recepciones_id = orden.getRecepcion().getId();

            ordenesRepository.insertarOrdenes( fecha_esperada, proveedores_nit, sucursales_id, cantidad, precio, recepciones_id);
            Orden nuevoOrdenes = ordenesRepository.darOrdenesPorId(id);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoOrdenes);      
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
 
        }
    }
    @PostMapping("/Ordenes/{id}/edit/save")
    public ResponseEntity<?> editarOrdenes(@RequestBody Orden orden){
        try{
            Integer id = orden.getId();
            Date fecha_esperada = orden.getFechaEsperada();
            Integer proveedores_nit = orden.getProveedor().getNit();
            Integer sucursales_id = orden.getSucursal().getId();
            Integer cantidad = orden.getCantidad();
            Integer precio = orden.getPrecio();
            Integer recepciones_id = orden.getRecepcion().getId();

            ordenesRepository.actualizarOrdenes(id,fecha_esperada,proveedores_nit,sucursales_id,cantidad,precio,recepciones_id);
            Orden nuevoOrden = ordenesRepository.darOrdenesPorId(id);
            return ResponseEntity.status(HttpStatus.OK).body(nuevoOrden);      
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
 
        }
    }

}
