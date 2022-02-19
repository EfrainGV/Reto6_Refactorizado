package Excepciones;

public class BovedaVaciaException extends Exception{
    public BovedaVaciaException(){
        super("No se pueden eliminar articulos, ya que la boveda se encuentra vacía");
    }
}
