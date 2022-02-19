import java.util.Hashtable;

public class Banco {

    private Hashtable<String,Cliente> ht= new Hashtable<>();

    public void anhadirCliente(Cliente c){
        String cedula = c.getCedula();
        ht.put(cedula,c);
    }
    public void removerCliente(String cedulaCliente){
        ht.remove(cedulaCliente);
    }
    public Cliente consultarCliente(String cedulaClienteConsultado){
        return ht.get(cedulaClienteConsultado);
    }

    public Hashtable<String, Cliente> getHt() {
        return ht;
    }

    public double valorTodosArticulosBoveda(){      // Suma el valor de todos los articulos que haya dentro de la boveda
        double sumaElementos = 0;
        for (String llave : ht.keySet()) {
            sumaElementos += ht.get(llave).valorTotalArticulosCliente();
        }
        return sumaElementos;
    }

}
