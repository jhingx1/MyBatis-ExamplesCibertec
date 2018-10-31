package dto;

public class Tutoriales {

    private Integer idtutorial;
    private String titulo;
    private String tipo;
    private Double precio;

    public Tutoriales() {
    }

    public Tutoriales(String titulo, String tipo, Double precio) {
        super();
        this.titulo = titulo;
        this.tipo = tipo;
        this.precio = precio;
    }

    public Integer getIdtutorial() {
        return idtutorial;
    }

    public void setIdtutorial(Integer idtutorial) {
        this.idtutorial = idtutorial;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
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

    @Override
    public String toString() {
        return "Tutoriales{" + "idtutorial=" + idtutorial + ", titulo=" + titulo + ", tipo=" + tipo + ", precio=" + precio + '}';
    }

}
