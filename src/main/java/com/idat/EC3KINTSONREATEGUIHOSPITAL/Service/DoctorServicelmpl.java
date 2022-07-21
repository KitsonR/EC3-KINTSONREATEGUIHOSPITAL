package com.idat.EC3KINTSONREATEGUIHOSPITAL.Service;

import com.idat.EC3KINTSONREATEGUIHOSPITAL.Modelo.Doctor;
import com.idat.EC3KINTSONREATEGUIHOSPITAL.Modelo.Especialidades;

import java.util.List;
public interface DoctorServicelmpl {

    Doctor guardar(Doctor doctor);
    void actualizar(Doctor doctor);
    void eliminar(int id_doctor);
    List<Doctor> listar();
    Doctor obtenerPorId(int id_doctor);

}
