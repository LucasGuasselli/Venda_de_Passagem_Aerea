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
 * @author Lucas Guasselli de Moraes
 * @version 1.0
 * @since 08/04/2017
 * 
 */
public class ClienteUI {
    
    private Digita d = new Digita();
    
    public void cadCliente(RepositorioClientes lista){
        //variaveis locais
            int limit = 10;
            String rg = "0000000000";
        do{
            rg = d.Digita("(min 4 e max 10 digitos)\nDigite o rg do Cliente: ");
        }while(rg.length() > limit || rg.length() <= 3);
       
        
            if(lista.clienteExist(rg)){
                System.out.println("Cliente ja esta cadastrado");
            }else{
               //variaveis locais
                String nome = d.Digita("Digite o nome do Cliente: ");
                String telefone = "(00)00000-0000";
                limit = 14;
                
                    do{
                      telefone = d.Digita("(min 8 e max 14 digitos)\nDigite "
                            + "o telefone do Cliente: ");                    
                    }while(telefone.length() > limit || telefone.length() <= 7);
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
           
           //formatacao para exibir Clientes
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
       }//fecha if
        
    }//fecha metodo search
}//fecha classe
