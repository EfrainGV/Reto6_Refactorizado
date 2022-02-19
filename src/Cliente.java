import java.util.ArrayList;
import java.util.Objects;


public class Cliente {
    private final String cedula;
    private String nombreCompleto;
    private final String paisProcedencia;
    private int contacto;
    private ArrayList<Articulo> articulosEnBoveda = new ArrayList<>();

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
        return contacto == cliente.contacto && cedula.equals(cliente.cedula) && nombreCompleto.equals(cliente.nombreCompleto) && paisProcedencia.equals(cliente.paisProcedencia) && Objects.equals(articulosEnBoveda, cliente.articulosEnBoveda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cedula, nombreCompleto, paisProcedencia, contacto, articulosEnBoveda);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cedula='" + cedula + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", paisProcedencia='" + paisProcedencia + '\'' +
                ", contacto=" + contacto +
                ", articulosEnBoveda=" + articulosEnBoveda +
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

    public ArrayList<Articulo> getArticulosEnBoveda() {
        return articulosEnBoveda;
    }

    public void anhadirALaBoveda(Articulo articuloAnhadir){
        this.articulosEnBoveda.add(articuloAnhadir);
    }

    public void eliminarDeLaBoveda(String articuloRemover) {
        this.articulosEnBoveda.removeIf(p -> (p.getNombre().equalsIgnoreCase(articuloRemover)));     //Extraigo del artículo que quiero eliminar su nombre, lo comparo con el nombre de los diversos articulos de mi lista y borro la primera ocurrencia que cumpla la condición
    }

    public double valorTotalArticulosCliente(){       //Suma el valor de todos los articulos que tenga el cliente.
        double sumaElementos = 0;

        for (Articulo articulo : this.articulosEnBoveda) {
            sumaElementos += articulo.getValorEstimado();
        }

        return sumaElementos;
    }
}
