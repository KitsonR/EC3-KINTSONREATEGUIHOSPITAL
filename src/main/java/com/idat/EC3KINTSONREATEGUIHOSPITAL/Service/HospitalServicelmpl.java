package com.idat.EC3KINTSONREATEGUIHOSPITAL.Service;

import com.idat.EC3KINTSONREATEGUIHOSPITAL.Modelo.Hospital;

import java.util.List;

public interface HospitalServicelmpl {

    Hospital guardar(Hospital hospital);
    void actualizar(Hospital hospital);
    void eliminar(int id_hospital);
    List<Hospital> listar();
    Hospital obtenerPorId(int id_hospital);

}
