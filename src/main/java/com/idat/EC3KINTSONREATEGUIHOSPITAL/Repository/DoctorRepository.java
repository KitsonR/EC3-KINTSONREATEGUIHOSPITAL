package com.idat.EC3KINTSONREATEGUIHOSPITAL.Repository;

import com.idat.EC3KINTSONREATEGUIHOSPITAL.Modelo.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

}
