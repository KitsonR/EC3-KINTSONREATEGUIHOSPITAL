package com.idat.EC3KINTSONREATEGUIHOSPITAL.Repository;

import com.idat.EC3KINTSONREATEGUIHOSPITAL.Modelo.Especialidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadesRepository extends JpaRepository<Especialidades, Integer> {

}
