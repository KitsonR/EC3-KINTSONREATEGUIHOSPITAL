package com.idat.EC3KINTSONREATEGUIHOSPITAL.Controller;

import com.idat.EC3KINTSONREATEGUIHOSPITAL.Modelo.Hospital;
import com.idat.EC3KINTSONREATEGUIHOSPITAL.Service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/hospital")
public class HospitalController {

    @Autowired
    private HospitalService service;

    @GetMapping("/listar")
    public List<Hospital> listar(){
        return service.listar();
    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@RequestBody Hospital nombre){
        Map<String, Object> response = new HashMap<>();
        service.guardar(nombre);
        response.put("hospítal", nombre);
        response.put("mensaje", "el hospital".concat(nombre.getNombre()).concat("se ha creado con exito"));
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @GetMapping("/buscar/{id_hospital}") //Http Method GET
    public ResponseEntity<?> buscar(@PathVariable Integer id_hospital) {
        Hospital h =service.obtenerPorId(id_hospital);
        if(h != null) {
            return  new ResponseEntity<Hospital>(service.obtenerPorId(id_hospital),HttpStatus.OK);
        }
        return  new ResponseEntity<Hospital>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/eliminar/{id_hospital}") //Http Method DELETE
    public ResponseEntity<?> borrar(@PathVariable Integer id_hospital) {
        Hospital h =service.obtenerPorId(id_hospital);
        Map<String, Object> response = new HashMap<>();
        if(h != null) {
            service.eliminar(id_hospital);
            response.put("mensaje", "El Hospital '" .concat(h.getNombre()).concat("' se ha eliminado con éxito!"));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/actualizar") //Http Method PUT
    public ResponseEntity<?> editar(@RequestBody Hospital nombre) {
        Hospital h = service.obtenerPorId(nombre.getId_hospital());
        Map<String, Object> response = new HashMap<>();
        if(h != null) {
            service.actualizar(nombre);
            response.put("hospital: ", nombre);
            response.put("mensaje", "Hospital " + nombre.getNombre() + " actualizado con éxito");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

