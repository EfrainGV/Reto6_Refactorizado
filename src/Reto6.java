/*
Realizado por:
Samuel Acevedo(CC.1001016099)
Efraín García(CC.1001370984)
*/

import Excepciones.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Reto6 {
    static Scanner lecturaDeDatos = new Scanner(System.in);
    public static void capturaDeDatos(Banco dataBase) throws FormatoStringIncorrectoException {
        System.out.print("# de documento: ");
        String numeroDocumento = lecturaDeDatos.next();
        if (!numeroDocumento.matches("^\\d+$")) {
            throw new FormatoStringIncorrectoException("Solo puede contener numeros enteros");
        }
        System.out.print("Nombre Completo: ");
        lecturaDeDatos.nextLine();
        String nombreCompleto = lecturaDeDatos.nextLine();
        if (!nombreCompleto.matches("^\\D+$")) {
            throw new FormatoStringIncorrectoException("El nombre completo solo admite letras y espacios");
        }
        System.out.print("Pais de procedencia: ");
        String paisProcedencia = lecturaDeDatos.nextLine();
        if (!paisProcedencia.matches("^\\D+$")) {
            throw new FormatoStringIncorrectoException("El nombre de un pais solo puede tener letras y espacios");
        }
        System.out.print("Numero para localizacion: ");
        int numeroLocalizacion = lecturaDeDatos.nextInt();

        if(dataBase.getHt().containsKey(numeroDocumento)){
            throw new NullPointerException();
        }else {
            dataBase.anhadirCliente(new Cliente(numeroDocumento, nombreCompleto, paisProcedencia, numeroLocalizacion));
        }
    }

    public static String eliminacionCliente(Banco dataBase) throws NoExisteClienteException{

        System.out.print("Escriba el numero de documento del cliente a eliminar: ");
        lecturaDeDatos.nextLine();
        String numeroDocumento = lecturaDeDatos.nextLine();
        if(dataBase.consultarCliente(numeroDocumento) == null){
            throw new NoExisteClienteException();
        }else{
        dataBase.removerCliente(numeroDocumento);}
        return "Se elimino el cliente con el siguiente numero de documento: "+numeroDocumento;
    }
    public static void accesoAlCliente(Banco dataBase) throws NoExisteClienteException, FormatoStringIncorrectoException, CarritoVacioException {
        System.out.println("Escriba el numero de documento del cliente a consultar");
        String claveConsulta = lecturaDeDatos.next();

        if(!claveConsulta.matches("^\\d+$")){
            throw new FormatoStringIncorrectoException("Solo puede contener numeros enteros");
        }
        if(dataBase.consultarCliente(claveConsulta) == null){
            throw new NoExisteClienteException();
        }else {
            System.out.println("La informacion del cliente seleccionado es la siguiente");
            System.out.println("# de documento: = " + dataBase.consultarCliente(claveConsulta).getCedula());
            System.out.println("Nombre completo = " + dataBase.consultarCliente(claveConsulta).getNombreCompleto());
            System.out.println("Pais de procedencia = " + dataBase.consultarCliente(claveConsulta).getPaisProcedencia());
            System.out.println("Numero de localizacion = " + dataBase.consultarCliente(claveConsulta).getContacto());
            System.out.println("Elementos en carrito = " + dataBase.consultarCliente(claveConsulta).getCarrito());

            modificacionCliente(dataBase, claveConsulta);
        }
    }
    public static void modificacionCliente(Banco dataBase,String claveConsulta) throws CarritoVacioException {

        System.out.println("Desea ejecutar alguna accion sobre este cliente?");
        System.out.println("1. Eliminar cliente");
        System.out.println("2. Agregar articulos al carrito");
        System.out.println("3. Quitar articulos del carrito");
        System.out.println("4. Sumar los valores estimados en el carrito");
        System.out.println("5. Salir");
        System.out.print("Ingrese el numero de la operacion seleccionada: ");
        int opcionSeleccionadaSubmenu = lecturaDeDatos.nextInt();

        switch (opcionSeleccionadaSubmenu) {
            case 1:
                dataBase.removerCliente(claveConsulta);
                System.out.println("Se elimino el cliente de la base de datos");
                break;
            case 2:
                System.out.println("Ingrese la informacion del articulo a agregar");
                System.out.print("Nombre del articulo: ");
                String nombreArticulo = lecturaDeDatos.next();
                lecturaDeDatos.nextLine();
                System.out.print("Descripcion breve del articulo: ");
                String descripcionArticulo = lecturaDeDatos.nextLine();
                System.out.print("Valor estimado del articulo: ");
                double valorEstimadoArticulo = lecturaDeDatos.nextDouble();
                dataBase.consultarCliente(claveConsulta).anhadirAlCarrito(new Articulo(nombreArticulo, descripcionArticulo, valorEstimadoArticulo));
                System.out.println("Anhadido con exito");
                break;
            case 3:
                if(dataBase.consultarCliente(claveConsulta).getCarrito() == null){
                    throw new CarritoVacioException();
                }else {
                    System.out.println("Ingrese el nombre del articulo a remover");
                    String nombreArticuloRemover = lecturaDeDatos.next();
                    dataBase.consultarCliente(claveConsulta).eliminarDelCarrito(nombreArticuloRemover);
                    System.out.println("Se elimino del carrito el siguiente articulo: " + nombreArticuloRemover);
                    break;
                }
            case 4:
                System.out.println("La suma total de los valores estimados es: ");
                double sumaArticulos = dataBase.consultarCliente(claveConsulta).sumaElementosCarrito();
                System.out.println(sumaArticulos);
                break;
            case 5:
                System.exit(0);
        }
    }


    public static void main(String[] args){
        Banco dataBase = new Banco();

        while(true) {
            System.out.println("Bienvenido al Banco, seleccione la operacion a realizar");
            System.out.println("1. Crear cliente");
            System.out.println("2. Eliminar cliente");
            System.out.println("3. Consultar y modificar cliente");
            System.out.println("4. Suma de todos los articulos de todos los clientes");
            System.out.println("0. Salir");
            System.out.print("Ingrese el numero de la operacion seleccionada: ");
            int opcionSeleccionada=0;
            try {
                opcionSeleccionada = lecturaDeDatos.nextInt();
            }catch(InputMismatchException e){
                System.out.println("Ingrese solo el numero que representa la opcion escogida");
            }
            switch (opcionSeleccionada) {
                case 1:
                    try {
                        capturaDeDatos(dataBase);
                    }catch(FormatoStringIncorrectoException e){
                        System.out.println(e.getMessage()+", vuelva a intentarlo.");

                    }catch(InputMismatchException e){
                        System.out.println("El numero de localizacion ingresado no es un numero, vuelva a intentarlo");
                    }catch (NullPointerException e){
                        System.out.println("Los clientes no pueden compartir el numero de documento");

                    }
                    break;
                case 2:
                    try {
                        System.out.println(eliminacionCliente(dataBase));
                    }catch(NoExisteClienteException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        accesoAlCliente(dataBase);
                    }catch (FormatoStringIncorrectoException | NoExisteClienteException | CarritoVacioException e){
                        System.out.println(e.getMessage());
                    }catch(InputMismatchException e){
                        System.out.println("Error: Ingrese un numero correcto");
                    }
                    break;
                case 4:
                    System.out.println("La suma de todos los elementos en los carritos es: " + dataBase.sumaTodosCarritos());
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }

    }
}