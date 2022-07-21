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
@Table(name = "especialidades")
public class Especialidades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_especialidad;
    private String especialidad;
    private Integer dias_atiende;

    @JsonIgnoreProperties({"especialidades","hospital"})
    @ManyToMany(mappedBy = "especialidades", cascade ={CascadeType.PERSIST, CascadeType.MERGE})
    private List<Hospital>hospitales = new ArrayList<>();

}
