import java.util.Hashtable;

public class Banco {

    private Hashtable<String,Cliente> ht= new Hashtable<String,Cliente>();

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



}
