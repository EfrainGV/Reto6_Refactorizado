import java.util.Hashtable;
import java.util.Iterator;

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



    public double sumaTodosCarritos(){      //Itera el Hashtable, calcula el valor de la suma de cada cliente y la suma entre sí.
        double sumaElementos = 0;
        Iterator<String> it = ht.keySet().iterator();
        while(it.hasNext()){
            String llave = it.next();
            sumaElementos += ht.get(llave).sumaElementosCarrito();
        }
        return sumaElementos;
    }

    public Hashtable<String, Cliente> getHt() {
        return ht;
    }

}
