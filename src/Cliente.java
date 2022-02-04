import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;


public class Cliente {
    private String cedula;
    private String nombreCompleto;
    private String paisProcedencia;
    private int contacto;
    private ArrayList<Articulo> carrito = new ArrayList<>();

    public Cliente(String cedula, String nombreCompleto, String paisProcedencia, int contacto) {
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.paisProcedencia = paisProcedencia;
        this.contacto = contacto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return contacto == cliente.contacto && cedula.equals(cliente.cedula) && nombreCompleto.equals(cliente.nombreCompleto) && paisProcedencia.equals(cliente.paisProcedencia) && Objects.equals(carrito, cliente.carrito);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cedula, nombreCompleto, paisProcedencia, contacto, carrito);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cedula='" + cedula + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", paisProcedencia='" + paisProcedencia + '\'' +
                ", contacto=" + contacto +
                ", carrito=" + carrito +
                '}';
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getPaisProcedencia() {
        return paisProcedencia;
    }

    public int getContacto() {
        return contacto;
    }

    public ArrayList<Articulo> getCarrito() {
        return carrito;
    }

    public void anhadirAlCarrito(Articulo a){
        this.carrito.add(a);
    }

    public String eliminarDelCarrito(String articuloRemover) {
        this.carrito.removeIf(p -> (p.getNombre().equalsIgnoreCase(articuloRemover)));     //Extraigo del artículo que quiero eliminar su nombre, lo comparo con el nombre de los diversos articulos de mi lista y borro la primera ocurrencia que cumpla la condición
        return articuloRemover;
    }
    public double valorElementoCarrito(int posicionArticuloCarrito){
        return carrito.get(posicionArticuloCarrito).getValorEstimado();
    }
    public double sumaElementosCarrito(){       //Suma todos los valores de los elementos del carrito del Cliente.
        double sumaElementos = 0;

        Iterator<Articulo> it = this.carrito.iterator();

        while(it.hasNext()){
            sumaElementos += it.next().getValorEstimado();
        }

        return sumaElementos;
    }
}
