package com.idat.EC3KINTSONREATEGUIHOSPITAL.Controller;

import com.idat.EC3KINTSONREATEGUIHOSPITAL.Modelo.Recepcionista;
import com.idat.EC3KINTSONREATEGUIHOSPITAL.Service.RecepcionistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(path = "/api/recepcionista")
public class RecepcionistaController {
    @Autowired
    private RecepcionistaService service;

    @GetMapping("/listar")
    public List<Recepcionista> listar(){
        return service.listar();
    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@RequestBody Recepcionista recepcionistas){
        Map<String, Object> response = new HashMap<>();
        service.guardar(recepcionistas);
        response.put("Recepcionista", recepcionistas);
        response.put("mensaje", "el nombre".concat(recepcionistas.getUsuario()).concat("se ha creado con exito"));
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @GetMapping("/buscar/{id_recepcionista}") //Http Method GET
    public ResponseEntity<?> buscar(@PathVariable Integer id_recepcionista) {
        Recepcionista uc =service.obtenerPorId(id_recepcionista);
        if(uc != null) {
            return  new ResponseEntity<Recepcionista>(service.obtenerPorId(id_recepcionista),HttpStatus.OK);
        }
        return  new ResponseEntity<Recepcionista>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/eliminar/{id_recepcionista}") //Http Method DELETE
    public ResponseEntity<?> borrar(@PathVariable Integer id_recepcionista) {
        Recepcionista uc =service.obtenerPorId(id_recepcionista);
        Map<String, Object> response = new HashMap<>();
        if(uc != null) {
            service.eliminar(id_recepcionista);
            response.put("mensaje", "Recepcionista '" .concat(uc.getUsuario()).concat("Se ha eliminado con éxito!"));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/actualizar") //Http Method PUT
    public ResponseEntity<?> editar(@RequestBody Recepcionista recepcionistas) {
        Recepcionista uc = service.obtenerPorId(recepcionistas.getId_recepcionista());
        Map<String, Object> response = new HashMap<>();
        if(uc != null) {
            service.actualizar(recepcionistas);
            response.put("Recepcionista: ", recepcionistas);
            response.put("mensaje", "Recepcionista " + recepcionistas.getUsuario() + " se ha actualizado con éxito");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

