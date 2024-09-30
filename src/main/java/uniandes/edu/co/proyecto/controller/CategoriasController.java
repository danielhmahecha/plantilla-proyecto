package uniandes.edu.co.proyecto.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Categoria;
import uniandes.edu.co.proyecto.repositorio.CategoriaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class CategoriasController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/categorias/consulta")
    public ResponseEntity<Map<String, Object>> categoriaConsulta(
            @RequestParam(required = false) Integer codigo) {

        try {
            Categoria categoria = categoriaRepository.darCategoriaPorCodigo(codigo);
            Map<String, Object> response = new HashMap<>();
            response.put("categoria", categoria);
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            // En caso de error
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/categorias/new/save")
    public ResponseEntity<String> categoriaGuardar(@RequestBody Categoria categoria) {
        try {
            categoriaRepository.insertarCategoria(categoria.getNombre(), categoria.getDescripcion(),
                    categoria.getAlmacenamiento());
            return new ResponseEntity<>("Categoria guardada", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al guardar la categoria", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
