package com.idat.EC3KINTSONREATEGUIHOSPITAL.Modelo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_doctor;
    private String doctor;
    private Integer numero;

    @JsonIgnoreProperties({"doctor","hospital"})
    @ManyToMany(mappedBy = "doctor", cascade ={CascadeType.PERSIST, CascadeType.MERGE})
    private List<Hospital>hospitales = new ArrayList<>();

}
