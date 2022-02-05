import java.util.Arrays;
import java.util.Scanner;

public class Reto6 {

    public static void capturaDeDatos(Banco dataBase){
        System.out.print("# de documento: ");
        String numeroDocumento = lecturaDeDatos.next();
        System.out.print("Nombre Completo: ");
        String nombreCompleto = lecturaDeDatos.next();
        System.out.println("Pais de procedencia: ");
        String paisProcedencia = lecturaDeDatos.next();
        System.out.println("Numero para localizacion: ");
        int numeroLocalizacion = lecturaDeDatos.nextInt();
        dataBase.anhadirCliente(new Cliente(numeroDocumento,nombreCompleto,paisProcedencia,numeroLocalizacion));
    }

    public static String eliminacionCliente(Banco dataBase){
    //Manejar excepciones de input y de nullpointerexception para hashtable
        System.out.println("Escriba el numero de documento del cliente a eliminar");
        String numeroDocumento = lecturaDeDatos.nextLine();
        dataBase.removerCliente(numeroDocumento);
        return "Se elimino el cliente con el siguiente numero de documento"+numeroDocumento;
    }


    static Scanner lecturaDeDatos = new Scanner(System.in);

    public static void main(String[] args){
        Banco dataBase = new Banco();
        Cliente clientePrueba = new Cliente("41621737","Armando Casas", "Colombia", 123);
        dataBase.anhadirCliente(clientePrueba);
        System.out.println("Bienvenido al Banco, seleccione la operacion a realizar");
        System.out.println("1. Crear cliente");
        System.out.println("2. Eliminar cliente");
        System.out.println("3. Consultar y modificar cliente");
        //Hay que buscar que dos clientes no puedan tener la misma cedula.
        int opcionSeleccionada = lecturaDeDatos.nextInt();       //Buscar una manera de hacer que el primer switch se ejecute en loop
        switch(opcionSeleccionada){
            case 1:
                capturaDeDatos(dataBase);
                break;
            case 2:
                System.out.println(eliminacionCliente(dataBase));
                break;
            case 3:
                System.out.println("Escriba el numero de documento del cliente a consultar");
                String claveConsulta = lecturaDeDatos.next();
                System.out.println("La informacion del cliente seleccionado es la siguiente");
                System.out.println("# de documento: = "+dataBase.consultarCliente(claveConsulta).getCedula());
                System.out.println("Nombre completo = "+dataBase.consultarCliente(claveConsulta).getNombreCompleto());
                System.out.println("Pais de procedencia = "+dataBase.consultarCliente(claveConsulta).getPaisProcedencia());
                System.out.println("Numero de localizacion = "+dataBase.consultarCliente(claveConsulta).getContacto());
                System.out.println("Elementos en carrito = "+dataBase.consultarCliente(claveConsulta).getCarrito());
                System.out.println("Desea ejecutar alguna accion sobre este cliente?");
                System.out.println("1. Eliminar cliente");
                System.out.println("2. Agregar articulos al carrito");
                System.out.println("3. Quitar articulos del carrito");
                System.out.println("4. Sumar los valores estimados en el carrito");
                System.out.println("5. Salir");

                int opcionSeleccionadaSubmenu = lecturaDeDatos.nextInt();
                switch (opcionSeleccionadaSubmenu){
                    case 1:
                        dataBase.removerCliente(claveConsulta);     //Verificar que el cliente exista en la Hashtable antes de removerlo.
                        System.out.println("Se elimino el cliente de la base de datos");
                        break;
                    case 2:
                        System.out.println("Ingrese la informacion del articulo a agregar");
                        System.out.print("Nombre del articulo: ");
                        String nombreArticulo = lecturaDeDatos.next();
                        System.out.print("Descripcion breve del articulo");
                        String descripcionArticulo = lecturaDeDatos.next();
                        System.out.print("Valor estimado del articulo: ");
                        double valorEstimadoArticulo = lecturaDeDatos.nextDouble();
                        dataBase.consultarCliente(claveConsulta).anhadirAlCarrito(new Articulo(nombreArticulo,descripcionArticulo,valorEstimadoArticulo));
                        System.out.println("Anhadido con exito");
                        break;
                    case 3:
                        System.out.println("Ingrese el nombre del articulo a remover");
                        String nombreArticuloRemover = lecturaDeDatos.next();
                        dataBase.consultarCliente(claveConsulta).eliminarDelCarrito(nombreArticuloRemover);
                        System.out.println("Se elimino del carrito el siguiente articulo: "+nombreArticuloRemover);
                        break;              //Verificar si el carrito esta vacio
                    case 4:
                        System.out.println("La suma total de los valores estimados es: ");
                        double sumaArticulos = dataBase.consultarCliente(claveConsulta).sumaElementosCarrito();
                        System.out.println(sumaArticulos);  //Verificar si el carrito está vacio, para poder efectuar la suma
                        break;
                    case 5:
                        System.exit(0);
                }
                break;
            case 0:
                System.exit(0);
                break;
        }

        //Falta sumar el valor de todos los articulos del banco.






        /*
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
        System.out.println(db.sumaTodosCarritos());*/

    }
}
