package com.idat.EC3KINTSONREATEGUIHOSPITAL.DTO;

public class EspecialidadesDTOResponse {

    private Integer id_especialidad;
    private String especialidad;
    private Integer dias_atiende;

    public Integer getId_especialidad() {
        return id_especialidad;
    }

    public void setId_especialidad(Integer id_especialidad) {
        this.id_especialidad = id_especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Integer getDias_atiende() {
        return dias_atiende;
    }

    public void setDias_atiende(Integer dias_atiende) {
        this.dias_atiende = dias_atiende;
    }
}
