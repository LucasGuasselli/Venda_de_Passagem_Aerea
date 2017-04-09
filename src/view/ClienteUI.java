/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import model.Cliente;
import repositorio.RepositorioClientes;
import util.Digita;

/**
 *
 * @author lucas
 */
public class ClienteUI {
    
    private Digita d = new Digita();
    
    public void cadCliente(RepositorioClientes lista){
        String rg = d.Digita("Digite o rg do Cliente: ");
            if(lista.clienteExist(rg)){
                System.out.println("Cliente ja esta cadastrado");
            }else{
                String nome = d.Digita("Digite o nome do Cliente: ");
                String telefone = d.Digita("Digite o telefone do Cliente: ");
                try{
                  lista.addCliente(new Cliente(nome, rg, telefone));    
            } catch (Exception e){
                    System.out.println("ERRO ao cadastrar cliente");
              }//try-catch
            }//if-else
            
    }//fecha cadCliente
    
    public void showClientes(RepositorioClientes lista){
 
        if(lista.getListClientes().size() <=0){
           System.out.println("###################################");
           System.out.println("Nao existem clentes cadastrados!!!!");
       }else{
           System.out.println("###################################\n");
            System.out.println(String.format("%-10s", "RG") + "\t"
                    + String.format("%-20s", "|NOME") + "\t"
                    + String.format("%-15s", "|TELEFONE"));
            for (Cliente cliente : lista.getListClientes()) {
                System.out.println(String.format("%-10s", cliente.getRg()) + "\t"
                        + String.format("%-20s", "|" + cliente.getNome()) + "\t"
                        + String.format("%-15s", "|" + cliente.getTelefone()));
            }//fecha for
             
        }//fechaif-else     
           
    }//fecha metodo
    
    public void searchCliente(RepositorioClientes lista){
      String rg = d.Digita("Informe o RG do cliente: ");
          
       if(lista.searchCliente(rg) == false){
           System.out.println("Cliente nao cadastrado!!!!");
       }
        
    }
}//fecha classe
