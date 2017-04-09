
package repositorio;

import java.util.ArrayList;
import java.util.List;
import model.Cliente;

/**
 *
 * @author lucas
 */
public class RepositorioClientes {
    
    private List<Cliente> clientes;
    
    //construtor ja instanciando um novo ArrayList
    public RepositorioClientes() {
        clientes = new ArrayList<Cliente>();
    }//fecha construtor

    //metodos
    
    //adiciona cliente no Array
    public boolean addPacientes(Cliente cliente) {
        return (clientes.add(cliente));
    }//fecha addPaciente

    //mostra os clientes cadastrados no Array
    public List<Cliente> getListClientes() {
        return clientes;
    }//fecha get

    /*
    *Verifica se o cliente existe por meio do atributo RG
    *Se cliente ja existir, return TRUE, se não return FALSE;
    */
    public boolean clienteExist(String RG) {
        for (Cliente cliente : clientes) {
            if (cliente.getRg().equals(RG)) {
                return true;
            }//fecha if
        }//fecha for-each
        return false;
    }//fecha clienteExist

    /*
    *Procura clientes existentes no Array pelo seu rg
    *se a condicao for verdadeira, retorna o objeto CLIENTE, se nao retorna NULL
    */
    public Cliente searchCliente(String rg) {
        for (Cliente cliente : clientes) {
            if (cliente.getRg().equals(rg)) {
                return cliente;
           }//fecha if
        }//fecha for
        return null;
    }//fecha searchCliente
}//fecha classe

