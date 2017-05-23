/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DAO.ClienteDAO;
import java.sql.SQLException;
import java.util.List;
import static jdk.nashorn.internal.objects.NativeString.toLowerCase;
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
    ClienteDAO cDAO = new ClienteDAO();
    private Digita d = new Digita();
    
    //@param Objeto do tipo Cliente
    public void cadCliente(){
        //variaveis locais
     
            int limit = 10;
        
            String rg = d.digitaRg("\n(min 4 e max 10 digitos)\nDigite o rg do Cliente: ");
               
           // if(lista.clienteExist(rg)){
            //    System.out.println("Cliente ja esta cadastrado");
         
               //variaveis locais
                String nome = d.digitaNome("\nDigite o nome do Cliente: ");
                        //DEIXANDO SOMENTE A PRIMEIRA LETRA DO NOME MAIUSCULA
                        nome = nome.toLowerCase();
                        nome = nome.substring(0,1).toUpperCase().concat(nome.substring(1));
                String telefone = "(00)00000-0000";
                limit = 14;
                
                    do{
                      telefone = d.digita("\n(min 8 e max 14 digitos)\nDigite "
                            + "o telefone do Cliente: ");                    
                    }while(telefone.length() > limit || telefone.length() <= 7);
            try{
                  cDAO.cadastrarCliente(new Cliente(nome, rg, telefone)); 
            } catch (Exception e){
                    System.out.println("ERRO ao cadastrar cliente!");
              }//try-catch
            }//if-else   
    
    public void editaCliente() throws SQLException, ClassNotFoundException{
         //variaveis locais
     
            int limit = 10;
            String rg = "0000000000";
            Cliente cli;
            rg = d.digitaRg("\n(min 4 e max 10 digitos)\nDigite o rg do Cliente que deseja alterar: ");
            
            cli = (cDAO.procurarPorRg(rg));
            // if(lista.clienteExist(rg)){
            //    System.out.println("Cliente ja esta cadastrado");
         
               //variaveis locais
                      String  novoRg = d.digitaRg("\n(min 4 e max 10 digitos)\nDigite o NOVO rg do Cliente que deseja alterar: ");

                String nome = d.digitaNome("\nDigite o nome do Cliente: ");
                String telefone = "(00)00000-0000";
                limit = 14;
                
                    do{
                      telefone = d.digita("\n(min 8 e max 14 digitos)\nDigite "
                            + "o telefone do Cliente: ");                    
                    }while(telefone.length() > limit || telefone.length() <= 7);
            try{
                  cDAO.editarCliente(new Cliente(cli.getId(),nome, novoRg, telefone)); 
                    System.out.println("CLIENTE EDITADO COM SUCESSO!!!");
            } catch (Exception e){
                    System.out.println("ERRO ao cadastrar cliente");
            }//try-catch
                    
    }//fecha editaCliente
    
    public void deletaCliente() {
        String rg = (d.digita("Digite o RG do cliente que deseja deletar: "));
    try{
        Cliente cli = cDAO.procurarPorRg(rg);
            cDAO.deletarCliete(cli);
            
    }catch(Exception e){
                System.out.println("ERRO ao deletar cliente");
            }//try-catch
    }//try-catch

    public void procurarPorRg(){
        
      String rg = (d.digita("Digite o RG do cliente que deseja visualizar: "));  
      try{ 
       Cliente cli = cDAO.procurarPorRg(rg);
            showCliente(cli);          
        
    }catch(Exception e){
                    System.out.println("ERRO ao visualizar cliente");
              }//try-catch
 
    }//fecha método
    public void procurarClientesPorNome() throws ClassNotFoundException, SQLException {
        String nome = (d.digita("\nDigite o nome do Cliente: "));
        nome = nome.toLowerCase();
        nome = nome.substring(0,1).toUpperCase().concat(nome.substring(1));
            List<Cliente> listaCliente = cDAO.listarPorNome(nome);
                mostrarClientes(listaCliente);
    }//fecha pesquisarClientesPorNome
        
    //METODO QUE MOSTRA TODOS CLIENTES CADASTRADOS
    //@param Objeto do tipo Cliente
    public void showCliente(Cliente cli){
 
        System.out.println("###################################\n");
           
           //formatacao para exibir Clientes
           System.out.println(String.format("%-10s", "ID") + "\t"                    
                    + String.format("%-20s", "RG") + "\t"
                    + String.format("%-20s", "|NOME") + "\t"
                    + String.format("%-15s", "|TELEFONE"));
        
            System.out.println(String.format("%-10s", cli.getId()) + "\t"
                    + String.format("%-20s", "|" + cli.getNome()) + "\t"
                    + String.format("%-20s", cli.getRg()) + "\t"
                    + String.format("%-15s", "|" + cli.getTelefone()));          
    }//fecha método

    private void mostrarClientes(List<Cliente> listaClientes) {
        if (listaClientes.isEmpty()) {
            System.out.println("Pacientes nao encontrados!");
        } else {
            System.out.println("###################################\n");
           
            System.out.println(String.format("%-10s", "ID") + "\t"
                    + String.format("%-20s", "|RG") + "\t"
                    + String.format("%-20s", "|NOME") + "\t"
                    + String.format("%-15s", "|TELEFONE"));
            for (Cliente cliente : listaClientes) {
                System.out.println(String.format("%-10s", cliente.getId()) + "\t"
                        + String.format("%-20s", "|" + cliente.getNome()) + "\t"
                        + String.format("%-20s", cliente.getRg()) + "\t"
                        + String.format("%-15s", "|" + cliente.getTelefone()));
            }//fea for
        }//fecha if-else 
    }//fecha mostrarClientes  
    

    //METODO QUE VERIFICA SE O CLIENTE ESTA CADASTRADO
    //@param ArrayList do tipo RepositorioClientes
   /* public void searchCliente(RepositorioClientes lista){
        if(lista.getListClientes().size() > 0){
            String rg = d.digita("Informe o RG do cliente: ");
                if(lista.searchClienteByRg(rg) == false){
                   System.out.println("Cliente nao cadastrado!!!!");
                }//fecha if
        }else{
            System.out.println("NAO EXISTEM CLIENTES CADASTRADOS");
        }//fecha-if-else
    }//fecha metodo search
        */
        
}//fecha classe
