import java.util.Hashtable;

public class Reto6 {

    public static void main(String[] args){
        Banco db = new Banco();

        db.anhadirCliente(new Cliente("1001016099","Samuel Acevedo Bustamante","Colombia",1));
        Cliente Ruben1 = new Cliente("71621737","Ruben Dario Acevedo","Colombia",2);
        db.anhadirCliente(Ruben1);

        System.out.println(db.consultarCliente("71621737").getNombreCompleto());
        System.out.println(db.getHt().get("71621737").getNombreCompleto());

        Ruben1.anhadirAlCarrito(new Articulo("Huevos","De gallina",15000));
        Ruben1.anhadirAlCarrito(new Articulo("Leche","De vaca",2500));
        db.consultarCliente("1001016099").anhadirAlCarrito(new Articulo("Panela","Una arroba",30000));
        String cedulaClienteAConsultar = "71621737";

        System.out.println(db.consultarCliente(cedulaClienteAConsultar));
        db.consultarCliente(cedulaClienteAConsultar).valorElementoCarrito(1);


        System.out.println(db.consultarCliente("71621737").sumaElementosCarrito());
        System.out.println(db.consultarCliente("71621737").getCarrito().toString());
        System.out.println(db.consultarCliente("71621737").eliminarDelCarrito("Leche"));
        System.out.println(db.consultarCliente("71621737").getCarrito().toString());
        System.out.println(db.sumaTodosCarritos());

    }
}
