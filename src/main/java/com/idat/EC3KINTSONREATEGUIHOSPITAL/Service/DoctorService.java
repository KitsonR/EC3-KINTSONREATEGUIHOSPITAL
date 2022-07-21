package com.idat.EC3KINTSONREATEGUIHOSPITAL.Service;

import com.idat.EC3KINTSONREATEGUIHOSPITAL.Modelo.Doctor;
import com.idat.EC3KINTSONREATEGUIHOSPITAL.Modelo.Especialidades;
import com.idat.EC3KINTSONREATEGUIHOSPITAL.Repository.DoctorRepository;
import com.idat.EC3KINTSONREATEGUIHOSPITAL.Repository.EspecialidadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService implements DoctorServicelmpl{

    @Autowired
    private DoctorRepository repository;

    @Override
    public Doctor guardar(Doctor doctor) {

        return repository.save(doctor);
    }

    @Override
    public void actualizar(Doctor doctor) {
        repository.saveAndFlush(doctor);
    }

    @Override
    public void eliminar(int id_doctor) {
        repository.deleteById(id_doctor);
    }

    @Override
    public List<Doctor> listar() {

        return repository.findAll();
    }

    @Override
    public Doctor obtenerPorId(int id_doctor) {

        return repository.findById(id_doctor).orElse(null);
    }


}
