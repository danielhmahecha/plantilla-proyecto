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
import uniandes.edu.co.proyecto.modelo.Ordenes;
import uniandes.edu.co.proyecto.modelo.OrdenesPK;
import uniandes.edu.co.proyecto.repositorio.OrdenesRepository;

@RestController
public class OrdenesController {
    
    @Autowired
    private OrdenesRepository OrdenesRepository;

    @GetMapping("/Ordenes")
    public ResponseEntity<Collection<Ordenes>> Ordenes(){
        try{
            Collection<Ordenes> Ordenes = OrdenesRepository.darOrdenes();
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
            String estado = orden.getEstado();
            Integer proveedores_nit = orden.getProveedores().getId();
            Integer sucursales_id = orden.getSucursales().getId();
            Integer cantidad = orden.getCantidad();
            Integer precio = orden.getPrecio();
            Integer recepciones_id = orden.getRecepciones_id().getId();

            OrdenesRepository.insertarOrdenes( fecha_esperada, estado, proveedores_nit, sucursales_id, cantidad, precio, recepciones_id);
            Ordenes nuevoOrdenes = OrdenesRepository.darOrdenesPorId(id, fecha_esperada, estado, proveedores_nit, sucursales_id, cantidad, precio, recepciones_id);
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
            String estado = orden.getEstado();
            Integer proveedores_nit = orden.getProveedores().getId();
            Integer sucursales_id = orden.getSucursales().getId();
            Integer cantidad = orden.getCantidad();
            Integer precio = orden.getPrecio();
            Integer recepciones_id = orden.getRecepciones_id().getId();

            OrdenesRepository.actualizarOrdenes(id);
            Ordenes nuevoOrden = OrdenesRepository.darOrdenesPorId(id);
            return ResponseEntity.status(HttpStatus.OK).body(nuevoOrden);      
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
 
        }
    }

}
