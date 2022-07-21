package com.idat.EC3KINTSONREATEGUIHOSPITAL.DTO;

import com.idat.EC3KINTSONREATEGUIHOSPITAL.Modelo.Especialidades;

public class RecepcionistaDTORequest {

    private Integer id_recepcionista;
    private String usuario;
    private String password;
    private String rol;

    private Especialidades especialidad;

    public Integer getId_recepcionista() {
        return id_recepcionista;
    }

    public void setId_recepcionista(Integer id_recepcionista) {
        this.id_recepcionista = id_recepcionista;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Especialidades getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidades especialidad) {
        this.especialidad = especialidad;
    }
}
