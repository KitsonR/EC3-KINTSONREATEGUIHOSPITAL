package com.idat.EC3KINTSONREATEGUIHOSPITAL.Service;

import com.idat.EC3KINTSONREATEGUIHOSPITAL.Modelo.Recepcionista;
import java.util.List;

public interface RecepcionistaServicelmpl {

    Recepcionista guardar(Recepcionista usuario);
    void actualizar(Recepcionista usuario);
    void eliminar(int id_recepcionista);
    List<Recepcionista> listar();
    Recepcionista obtenerPorId(int id_recepcionista);

}
