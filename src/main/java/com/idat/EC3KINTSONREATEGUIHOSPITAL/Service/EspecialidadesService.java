package com.idat.EC3KINTSONREATEGUIHOSPITAL.Service;

import com.idat.EC3KINTSONREATEGUIHOSPITAL.Modelo.Especialidades;
import com.idat.EC3KINTSONREATEGUIHOSPITAL.Repository.EspecialidadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadesService implements EspecialidadesServicelmpl{

    @Autowired
    private EspecialidadesRepository repository;

    @Override
    public Especialidades guardar(Especialidades especialidades) {

        return repository.save(especialidades);
    }

    @Override
    public void actualizar(Especialidades especialidades) {
        repository.saveAndFlush(especialidades);
    }

    @Override
    public void eliminar(int id_especialidad) {
        repository.deleteById(id_especialidad);
    }

    @Override
    public List<Especialidades> listar() {

        return repository.findAll();
    }

    @Override
    public Especialidades obtenerPorId(int id_especialidad) {

        return repository.findById(id_especialidad).orElse(null);
    }

}
