/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Cliente;
import model.Venda;
import model.Voo;
import repositorio.RepositorioAvioes;
import repositorio.RepositorioClientes;
import repositorio.RepositorioVendas;
import repositorio.RepositorioVoos;
import util.Digita;
import util.VerificaDatas;

/**
 *
 * @author Lucas Guasselli de Moraes
 * @version 1.5
 * @since 19/04/2017
 * 
 */
public class VendaUI {

    //atributos
    private Digita d = new Digita();
    private VerificaDatas verifica = new VerificaDatas();
   //METODO QUE REALIZA O CADASTRO DA VENDA 
    //@param recebe todos os ArrayList do sistema         
    public void cadVenda(RepositorioVendas listaVendas, RepositorioClientes listaClientes, RepositorioAvioes listaAvioes, RepositorioVoos listaVoos){
        ClienteUI cliUI = new ClienteUI();
        VooUI vooUI = new VooUI();            

        if(listaClientes.getListClientes().size() > 0 || listaVoos.getListVoos().size() > 0 ){
            //variaveis locais
            Cliente cliente = null;
            Voo voo = null;
            String rg = "";
            String dataVoo = "";
            int limit = 10;
            int codigoAviao = 0;
        
            System.out.println("\nClientes cadastrados:\n");
            cliUI.showClientes(listaClientes);
            System.out.println("\nVoos cadastrados:\n");
            vooUI.showVoos(listaVoos);
            
            do{
                rg = d.digitaRg("\n(min 4 e max 10 digitos)\nInforme o rg do cliente que deseja realizar uma compra: ");
                
                if(listaClientes.clienteExist(rg) == true){
                    cliente = listaClientes.retornaCliente(rg);
                }else{
                    System.out.println("O rg digitado é nao corresponde a nenhum cliente!");   
                }//fecha if-else
            }while(cliente == null);
            
            do{
            codigoAviao = Integer.parseInt(d.digita("\nInforme o codigo do aviao:"));
            dataVoo = d.digitaData("Informe a data do voo: ");
             
                if(listaAvioes.AviaoExistByCod(codigoAviao) == true){
                    if(listaVoos.verificaAviaoData(dataVoo,listaAvioes.retornaAviao(codigoAviao)) == true){
                        voo = listaVoos.retornaVoo(listaAvioes.retornaAviao(codigoAviao));
                    }else{
                        System.out.println("Aviao nao possui voo para esta data!"); 
                    }//fecha if-else                                           
                }else{
                    System.out.println("AVIAO NAO EXISTE");
                }//fecha-if-else
               }while(voo == null);  
            
        voo.reservaAssento();
            
        try{
              listaVendas.addVenda(new Venda(cliente, voo));
                    System.out.println("VENDA CADASTRADA COM SUCESSO!!!");
            } catch (Exception e){
                    System.out.println("ERRO ao cadastrar voo");
                }//try-catch
   
        }else{
                System.out.println("So e permitido realizar uma venda quando tiver pelo menos"
                        + " um cliente e um voo cadastrado!");
        }//fecha if-else
    
    }//fecha cadVoo
//METODO QUE MOSTRA TODAS AS VENDAS REALIZADAS 
   //@param ArrayList do tipo RepositorioVendas
   public void verVenda(RepositorioVendas listaVendas) {
        if(listaVendas.getListVendas().size() <=0){
           System.out.println("###################################");
           System.out.println("Nenhuma venda foi realizada!!!!");
       }else{
           System.out.println("###################################\n");
           
           //formatacao para exibir voos
           
            for (Venda venda : listaVendas.getListVendas()) {
               System.out.println(String.format("%-10s", "CLIENTE") + "\t");
                    System.out.println(String.format("%-10s", venda.getCliente()) + "\t");
                        System.out.println(String.format("%-10s", "VOO") + "\t");
                            System.out.println(String.format("%-10s", venda.getVoo()) + "\t");    
                                 System.out.println(String.format("%-10s", "ASSENTO RESERVADO") + "\t");
                                      System.out.println(String.format("%-10s", "Assento n: " +venda.getVoo().getMeuAssento()) + "\t");    
                                
            System.out.println("=============================================\n");
            }//fecha for
             
            }//fechaif-else   
   }//fecha classe
    
    
    
    
}//fecha classe
