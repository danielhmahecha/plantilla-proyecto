package uniandes.edu.co.proyecto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.repositorio.VendeRepository;

@RestController
public class VendeController 
{
    @Autowired
    private VendeRepository vendeRepository;

    @GetMapping("/vende/consulta")
    public ResponseEntity<Collection<String>> vendeConsulta(@RequestParam(required = false) Integer codigo_de_barras)
    {
        try
        {
            Collection<String> sucursales = vendeRepository.darSucursalesPorProducto(codigo_de_barras);
            return ResponseEntity.ok(sucursales);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
