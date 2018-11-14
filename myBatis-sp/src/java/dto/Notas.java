package dto;

public class Notas {

    private Integer idalumno;
    private String alumno;
    private Short nota1;
    private Short nota2;
    private Short nota3;
    private String comentario;

    public Integer getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(Integer idalumno) {
        this.idalumno = idalumno;
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    public Short getNota1() {
        return nota1;
    }

    public void setNota1(Short nota1) {
        this.nota1 = nota1;
    }

    public Short getNota2() {
        return nota2;
    }

    public void setNota2(Short nota2) {
        this.nota2 = nota2;
    }

    public Short getNota3() {
        return nota3;
    }

    public void setNota3(Short nota3) {
        this.nota3 = nota3;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }   
    
}
