public class Articulo {
    private String nombre;
    private String descripcion;
    private double valorEstimado;

    public Articulo(String nombre,String descripcion,double valorEstimado){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valorEstimado = valorEstimado;
    }

    public String getNombre() {
        return nombre;
    }

    public double getValorEstimado() {
        return valorEstimado;
    }
}
