package data.model;

import java.util.Date;

public class Cursos {
    private Integer idcursos;

    private String nombrecursos;

    private String descripcion;

    private Date fechainicio;

    private Date fechafin;

    private String tipo;

    private Integer horas;

    private Integer idprofesores;

    public Integer getIdcursos() {
        return idcursos;
    }

    public void setIdcursos(Integer idcursos) {
        this.idcursos = idcursos;
    }

    public String getNombrecursos() {
        return nombrecursos;
    }

    public void setNombrecursos(String nombrecursos) {
        this.nombrecursos = nombrecursos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    public Integer getIdprofesores() {
        return idprofesores;
    }

    public void setIdprofesores(Integer idprofesores) {
        this.idprofesores = idprofesores;
    }
}