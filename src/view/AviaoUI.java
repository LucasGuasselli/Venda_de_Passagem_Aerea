/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Aviao;
import repositorio.RepositorioAvioes;
import util.Digita;

/**
 * 
 * @author Lucas Guasselli de Moraes
 * @version 1.3
 * @since 13/04/2017
 * 
 */
public class AviaoUI {
    private Digita d = new Digita();
    //METODO DE CADASTRO DE AVIAO
    //@param ArrayList do tipo RepositorioAvioes

    public void cadAviao(RepositorioAvioes lista){
        //variaveis locais
            int limit = 30;
            String nome = "";
       
            nome = d.digitaNome("\n(min 3 e max 30 caracteres)\nDigite o nome do Aviao: ");       
        
            if(lista.AviaoExistByName(nome)){
                System.out.println("Aviao ja esta cadastrado");
            }else{
               //variaveis locais
                
                int assentos = 0;
                limit = 200;
                
                    do{
                      assentos = Integer.parseInt(d.digita("\n(min 80 e max 200 assentos)"
                              + "\nDigite a quantidade de assentos do Aviao: "));                    
                    }while(assentos > limit || assentos <= 79);
                try{
                  lista.addAviao(new Aviao(nome, assentos));
                    System.out.println("AVIAO CADASTRADO COM SUCESSO!!!");
            } catch (Exception e){
                    System.out.println("ERRO ao cadastrar aviao");
              }//try-catch
            }//if-else
            
    }//fecha cadCliente
    //METODO QUE MOSTRA TODOS AVIOES 
    //@param ArrayList RepositorioAvioes
    public void showAvioes(RepositorioAvioes lista){
 
        if(lista.getListAvioes().size() <=0){
           System.out.println("###################################");
           System.out.println("Nao existem clentes cadastrados!!!!");
       }else{
           System.out.println("###################################\n");
           
           //formatacao para exibir Clientes
           System.out.println(String.format("%-10s", "CODIGO") + "\t"
                    + String.format("%-20s", "|NOME") + "\t"
                    + String.format("%-15s", "|QUANTIDADE DE ASSENTOS"));
            for (Aviao aviao : lista.getListAvioes()) {
                System.out.println(String.format("%-10s", aviao.getCodigo()) + "\t"
                        + String.format("%-20s", "|" + aviao.getNome()) + "\t"
                        + String.format("%-15s", "|" + aviao.getQtdeAssentos()));
            }//fecha for
             
        }//fechaif-else     
           
    }//fecha metodo
    //METODO QUE VERIFICA SE UM AVIAO ESTA CADASTRADO
    //@param ArrayList o tipo RepositorioAvioes
    public void searchAviao(RepositorioAvioes lista){
        if(lista.getListAvioes().size() > 0){  
            int codigo = Integer.parseInt(d.digita("Informe o Codigo do aviao: "));
                if(lista.searchAviaoByCodigo(codigo) == false){
                   System.out.println("Aviao nao cadastrado!!!!");
                }//fecha if
            }else{
                System.out.println("NAO EXISTEM AVIOES CADASTRADOS");
        }//FECHA IF-ELSE
    }//fecha metodo search
}//fecha classe
