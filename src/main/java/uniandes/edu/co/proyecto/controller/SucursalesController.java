package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Sucursal;
import uniandes.edu.co.proyecto.repositorio.SucursalRepository;

@RestController
public class SucursalesController 
{
    @Autowired
    private SucursalRepository sucursalRepository;

    @PostMapping("/sucursales/new/save")
    public ResponseEntity<String> sucursalGuardar(@RequestBody Sucursal sucursal)
    {
        try
        {
            sucursalRepository.insertarSucursal(sucursal.getDireccion(), sucursal.getTelefono(), sucursal.getNombre(), sucursal.getCiudad_codigo().getCodigo());
            return new ResponseEntity<>("Sucursal creada exitosamente.",HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>("Error al crear la sucursal.",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
