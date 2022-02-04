import java.util.ArrayList;



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

    public String eliminarDelCarrito(Articulo a) {
        String articuloARemover = a.getNombre();
        this.carrito.removeIf(p -> (p.getNombre().equalsIgnoreCase(articuloARemover)));     //Extraigo del artículo que quiero eliminar su nombre, lo comparo con el nombre de los diversos articulos de mi lista y borro la primera ocurrencia que cumpla la condición
        return articuloARemover;
    }
    public double valorElementoCarrito(int posicionArticuloCarrito){
        return carrito.get(posicionArticuloCarrito).getValorEstimado();
    }
}
