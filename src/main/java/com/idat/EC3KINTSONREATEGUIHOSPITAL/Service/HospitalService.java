package com.idat.EC3KINTSONREATEGUIHOSPITAL.Service;


import com.idat.EC3KINTSONREATEGUIHOSPITAL.Modelo.Hospital;
import com.idat.EC3KINTSONREATEGUIHOSPITAL.Repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalService implements HospitalServicelmpl{

    @Autowired
    private HospitalRepository repository;

    @Override
    public Hospital guardar(Hospital hospital) {

        return repository.save(hospital);
    }

    @Override
    public void actualizar(Hospital hospital) {
        repository.saveAndFlush(hospital);

    }

    @Override
    public void eliminar(int id_hospital) {
        repository.deleteById(id_hospital);
    }

    @Override
    public List<Hospital> listar() {

        return repository.findAll();
    }

    @Override
    public Hospital obtenerPorId(int id_hospital) {

        return repository.findById(id_hospital).orElse(null);
    }

}

