package com.idat.EC3KINTSONREATEGUIHOSPITAL.Modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "recepcionista")
public class Recepcionista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_recepcionista;
    private String usuario;
    private String password;
    private String rol;

    @OneToOne
    @JoinColumn(name = "id_recepcionista",
            nullable = false,
            unique = true)
    private Recepcionista clientes;


}
