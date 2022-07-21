package com.idat.EC3KINTSONREATEGUIHOSPITAL.Repository;


import com.idat.EC3KINTSONREATEGUIHOSPITAL.Modelo.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

}
