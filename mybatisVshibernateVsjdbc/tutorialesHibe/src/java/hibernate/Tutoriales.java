package hibernate;

public class Tutoriales implements java.io.Serializable {

    private Integer idtutorial;
    private String titulo;
    private String tipo;
    private Double precio;

    public Tutoriales() {
    }

    public Tutoriales(String titulo, String tipo, double precio) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.precio = precio;
    }

    public Integer getIdtutorial() {
        return this.idtutorial;
    }

    public void setIdtutorial(Integer idtutorial) {
        this.idtutorial = idtutorial;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

}
