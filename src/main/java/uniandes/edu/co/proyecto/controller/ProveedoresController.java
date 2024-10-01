package uniandes.edu.co.proyecto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import uniandes.edu.co.proyecto.modelo.Proveedor;
import uniandes.edu.co.proyecto.repositorio.ProveedoresRepository;

@RestController
public class ProveedoresController {
    
    @Autowired
    private ProveedoresRepository proveedoresRepository;

    @GetMapping("/proveedores")
    public ResponseEntity<Collection<Proveedor>> proveedores(){
        try{
            Collection<Proveedor> proveedores = proveedoresRepository.darProveedores();
            return ResponseEntity.ok(proveedores);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/proveedores/new/save")
    public ResponseEntity<?> createProveedores(@RequestBody Proveedor proveedor){
        try{
            String nombre = proveedor.getNombre();
            String dirección = proveedor.getDireccion();
            String persona_de_contacto = proveedor.getPersonaDeContacto();
            Integer teléfono_de_contacto = proveedor.getTelefonoDeContacto();
            Integer sucursal_id = proveedor.getSucursales_id().getId();

            proveedoresRepository.insertarProveedores( nombre, dirección, persona_de_contacto, teléfono_de_contacto, sucursal_id);
            return new ResponseEntity<>("Proveedor creado conéxito",HttpStatus.CREATED);    
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/proveedores/{nit}/save") 
    public ResponseEntity<?> proveedorEditarGuardar(@PathVariable("nit") Integer nit, @RequestBody Proveedor proveedor){
        try{
            String nombre = proveedor.getNombre();
            String dirección = proveedor.getDireccion();
            String persona_de_contacto = proveedor.getPersonaDeContacto();
            Integer teléfono_de_contacto = proveedor.getTelefonoDeContacto();
            Integer sucursal_id = proveedor.getSucursales_id().getId();
            proveedoresRepository.actualizarProveedores(nit, nombre, dirección, persona_de_contacto, teléfono_de_contacto, sucursal_id);
            Proveedor nuevoProveedor = proveedoresRepository.darProveedoresPorId(nit);
            return ResponseEntity.status(HttpStatus.OK).body(nuevoProveedor);      
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
