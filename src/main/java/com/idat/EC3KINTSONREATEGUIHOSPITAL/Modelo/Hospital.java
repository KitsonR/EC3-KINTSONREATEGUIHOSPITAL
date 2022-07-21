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
@Table(name = "hospital")
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_hospital;
    private String nombre;
    private String descripcion;
    private String distrito;

    @JsonIgnoreProperties({"hospital"})
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "hospital_especialidades",
            joinColumns = @JoinColumn(
                    name = "id_hospital",
                    nullable = false,
                    unique = true

            ),
            inverseJoinColumns = @JoinColumn(
                    name = "id_especialidad",
                    nullable = false,
                    unique = true
            )

    )
    private List<Especialidades> especialidades = new ArrayList<>();


}
