package Excepciones;
public class NoExisteClienteException extends Exception{
    public NoExisteClienteException(){
        super("El cliente seleccionado no existe en la base de datos");
    }

}
