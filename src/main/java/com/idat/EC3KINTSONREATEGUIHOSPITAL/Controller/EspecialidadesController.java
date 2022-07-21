package com.idat.EC3KINTSONREATEGUIHOSPITAL.Controller;

import com.idat.EC3KINTSONREATEGUIHOSPITAL.Modelo.Especialidades;
import com.idat.EC3KINTSONREATEGUIHOSPITAL.Service.EspecialidadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/especialidad")
public class EspecialidadesController {

    @Autowired
    private EspecialidadesService service;

    @GetMapping("/listar")
    public List<Especialidades> listar(){
        return service.listar();
    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@RequestBody Especialidades especialidades){
        Map<String, Object> response = new HashMap<>();
        service.guardar(especialidades);
        response.put("cliente", especialidades);
        response.put("mensaje", "el cliente".concat(especialidades.getEspecialidad()).concat("se ha creado con exito"));
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @GetMapping("/buscar/{id_especialidad}") //Http Method GET
    public ResponseEntity<?> buscar(@PathVariable Integer id_especialidad) {
        Especialidades c =service.obtenerPorId(id_especialidad);
        if(c != null) {
            return  new ResponseEntity<Especialidades>(service.obtenerPorId(id_especialidad),HttpStatus.OK);
        }
        return  new ResponseEntity<Especialidades>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/eliminar/{id_especialdad}") //Http Method DELETE
    public ResponseEntity<?> borrar(@PathVariable Integer id_especialidad) {
        Especialidades c =service.obtenerPorId(id_especialidad);
        Map<String, Object> response = new HashMap<>();
        if(c != null) {
            service.eliminar(id_especialidad);
            response.put("mensaje", "Doctor '" .concat(c.getEspecialidad()).concat("' eliminado con éxito!"));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/actualizar") //Http Method PUT
    public ResponseEntity<?> editar(@RequestBody Especialidades especialidades) {
        Especialidades c = service.obtenerPorId(especialidades.getId_especialidad());
        Map<String, Object> response = new HashMap<>();
        if(c != null) {
            service.actualizar(especialidades);
            response.put("producto: ", especialidades);
            response.put("mensaje", "Cliente " + especialidades.getEspecialidad() + " actualizado con éxito");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
