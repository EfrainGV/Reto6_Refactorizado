import java.util.Hashtable;

public class Reto6 {
    public static void datosCliente(Cliente cliente){   //Extrae los atributos del cliente, el carrito aparece identificando por objetos(cambiar)
        System.out.println(cliente.getNombreCompleto());
        System.out.println(cliente.getCedula());
        System.out.println(cliente.getContacto());
        System.out.println(cliente.getPaisProcedencia());
        System.out.println(cliente.getCarrito());
    }

    public static void main(String[] args){
        Banco db = new Banco();
        Hashtable<String,Cliente> tabla = db.getHt();
        db.anhadirCliente(new Cliente("1001016099","Samuel Acevedo Bustamante","Colombia",1));
        Cliente Ruben1 = new Cliente("71621737","Ruben Dario Acevedo","Colombia",2);
        db.anhadirCliente(Ruben1);

        System.out.println(db.consultarCliente("71621737").getNombreCompleto());
        System.out.println(db.getHt().get("71621737").getNombreCompleto());

        Ruben1.anhadirAlCarrito(new Articulo("Huevos","De gallina",15000));
        Ruben1.anhadirAlCarrito(new Articulo("Leche","De vaca",2500));

        String cedulaClienteAConsultar = "71621737";
        db.consultarCliente(cedulaClienteAConsultar).valorElementoCarrito(1);

        int sumaElementos = 0;
        for(int i=0;i<db.consultarCliente(cedulaClienteAConsultar).getCarrito().size();i++) {     //Ciclo que suma el valor de los elementos del carrito
            sumaElementos +=db.consultarCliente(cedulaClienteAConsultar).valorElementoCarrito(i);
            System.out.println(db.consultarCliente(cedulaClienteAConsultar).valorElementoCarrito(i));
        }
        System.out.println(sumaElementos);
        datosCliente(Ruben1);

    //La suma de todos los articulos se da al aplicar el mismo ciclo pero navegando por cada elemento de la hashtable

    }
}
