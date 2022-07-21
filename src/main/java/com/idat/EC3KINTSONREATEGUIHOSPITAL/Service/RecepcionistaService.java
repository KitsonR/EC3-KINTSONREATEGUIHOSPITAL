package com.idat.EC3KINTSONREATEGUIHOSPITAL.Service;

import com.idat.EC3KINTSONREATEGUIHOSPITAL.Modelo.Recepcionista;
import com.idat.EC3KINTSONREATEGUIHOSPITAL.Repository.RecepcionistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecepcionistaService implements RecepcionistaServicelmpl{

    @Autowired
    private RecepcionistaRepository repository;

    @Override
    public Recepcionista guardar(Recepcionista usuario) {

        return repository.save(usuario);
    }

    @Override
    public void actualizar(Recepcionista usuario) {
        repository.saveAndFlush(usuario);
    }

    @Override
    public void eliminar(int id_usuario) {
        repository.deleteById(id_usuario);
    }

    @Override
    public List<Recepcionista> listar() {

        return repository.findAll();
    }

    @Override
    public Recepcionista obtenerPorId(int id_usuario) {

        return repository.findById(id_usuario).orElse(null);
    }

}
