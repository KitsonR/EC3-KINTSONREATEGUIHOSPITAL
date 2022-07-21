package com.idat.EC3KINTSONREATEGUIHOSPITAL.Controller;

import com.idat.EC3KINTSONREATEGUIHOSPITAL.Modelo.Doctor;
import com.idat.EC3KINTSONREATEGUIHOSPITAL.Modelo.Especialidades;
import com.idat.EC3KINTSONREATEGUIHOSPITAL.Service.DoctorService;
import com.idat.EC3KINTSONREATEGUIHOSPITAL.Service.EspecialidadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/doctor")
public class DoctorController {
    @Autowired
    private DoctorService service;

    @GetMapping("/listar")
    public List<Doctor> listar(){
        return service.listar();
    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@RequestBody Doctor doctor){
        Map<String, Object> response = new HashMap<>();
        service.guardar(doctor);
        response.put("doctor", doctor);
        response.put("mensaje", "el doctor".concat(doctor.getDoctor()).concat("se ha creado con exito"));
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @GetMapping("/buscar/{id_doctor}") //Http Method GET
    public ResponseEntity<?> buscar(@PathVariable Integer id_doctor) {
        Doctor c =service.obtenerPorId(id_doctor);
        if(c != null) {
            return  new ResponseEntity<Doctor>(service.obtenerPorId(id_doctor),HttpStatus.OK);
        }
        return  new ResponseEntity<Doctor>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/eliminar/{id_doctor}") //Http Method DELETE
    public ResponseEntity<?> borrar(@PathVariable Integer id_doctor) {
        Doctor c =service.obtenerPorId(id_doctor);
        Map<String, Object> response = new HashMap<>();
        if(c != null) {
            service.eliminar(id_doctor);
            response.put("mensaje", "Doctor '" .concat(c.getDoctor()).concat("' eliminado con éxito!"));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/actualizar") //Http Method PUT
    public ResponseEntity<?> editar(@RequestBody Doctor doctor) {
        Doctor c = service.obtenerPorId(doctor.getId_doctor());
        Map<String, Object> response = new HashMap<>();
        if(c != null) {
            service.actualizar(doctor);
            response.put("producto: ", doctor);
            response.put("mensaje", "Doctor " + doctor.getDoctor() + " actualizado con éxito");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
