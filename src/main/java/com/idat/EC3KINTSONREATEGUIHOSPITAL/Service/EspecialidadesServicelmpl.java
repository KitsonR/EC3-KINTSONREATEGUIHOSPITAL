package com.idat.EC3KINTSONREATEGUIHOSPITAL.Service;

import com.idat.EC3KINTSONREATEGUIHOSPITAL.Modelo.Especialidades;

import java.util.List;

public interface EspecialidadesServicelmpl {

    Especialidades guardar(Especialidades especialidades);
    void actualizar(Especialidades especialidades);
    void eliminar(int id_especialidad);
    List<Especialidades> listar();
    Especialidades obtenerPorId(int id_especialidad);
}
