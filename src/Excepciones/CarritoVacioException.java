package Excepciones;

public class CarritoVacioException extends Exception{
    public CarritoVacioException(){
        super("No se pueden eliminar articulos, ya que el carrito está vacio");
    }
}
