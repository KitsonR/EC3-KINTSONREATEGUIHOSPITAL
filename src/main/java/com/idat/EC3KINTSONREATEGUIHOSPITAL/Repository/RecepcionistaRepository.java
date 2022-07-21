package com.idat.EC3KINTSONREATEGUIHOSPITAL.Repository;

import com.idat.EC3KINTSONREATEGUIHOSPITAL.Modelo.Recepcionista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecepcionistaRepository extends JpaRepository<Recepcionista, Integer> {

    Recepcionista findByUsuario(String nombre);

}
