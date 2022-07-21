package com.idat.EC3KINTSONREATEGUIHOSPITAL.DTO;

public class HospitalDTOResponse {

    private Integer id_hospital;
    private String nombre;
    private String direccion;
    private Integer distrito;

    public Integer getId_hospital() {
        return id_hospital;
    }

    public void setId_hospital(Integer id_hospital) {
        this.id_hospital = id_hospital;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getDistrito() {
        return distrito;
    }

    public void setDistrito(Integer distrito) {
        this.distrito = distrito;
    }
}
