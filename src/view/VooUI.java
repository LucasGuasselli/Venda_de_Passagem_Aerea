/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.time.LocalDate;
import model.Aviao;
import model.Voo;
import repositorio.RepositorioAvioes;
import repositorio.RepositorioClientes;
import repositorio.RepositorioVoos;
import util.Digita;
import util.VerificaDatas;

/**
 *
 * @author Lucas Guasselli de Moraes
 * @version 1.4
 * @since 16/04/2017
 * 
 */
public class VooUI {
    //atributos
    private Digita d = new Digita();
    private VerificaDatas verifica = new VerificaDatas();
    
    public void cadVoo(RepositorioVoos listaVoos, RepositorioAvioes listaAvioes){
             //variaveis locais
        if(listaAvioes.getListAvioes().size() > 0){
            LocalDate dataHoje = LocalDate.now();
            int limit = 30;
            String origem = "";
            String destino = "";
            String dataVoo = "";
            Aviao aviao = null;
            int codigoAviao = 0;
        do{
            origem = d.Digita("\n(min 3 e max 30 digitos)\nDigite o origem do voo: ");
        }while(origem.length() > limit || origem.length() <= 3);
        
        do{
            destino = d.Digita("\n(min 3 e max 30 digitos)\nDigite o destino do voo: ");
        }while(destino.length() > limit || destino.length() <= 3);
        
        
        
        do{
            do{
                dataVoo = d.Digita("\nDigite a data do voo no formato (dd/mm/aaaa):");
                    if(verifica.verificaDataAnterior(dataVoo) == true){
                        System.out.println("\nDigite uma data igual ou a partir da data atual");
                    }//fecha if
        }while(dataVoo.length() != 10 || verifica.verificaDataAnterior(dataVoo) == true);
            
            codigoAviao = Integer.parseInt(d.Digita("\nInforme o codigo do aviao:"));
         
        if(listaAvioes.AviaoExistByCod(codigoAviao) == true){
            if(listaVoos.verificaAviao(listaAvioes.retornaAviao(codigoAviao)) == false
                    || listaVoos.verificaDataVoos(dataVoo) == true){
                aviao = listaAvioes.retornaAviao(codigoAviao);
            }else{
                System.out.println("Aviao ja possui um voo nessa data");
            }
        }else{
            System.out.println("Aviao nao cadastrado!!");
        } 
        }while(aviao == null);
               
        try{
              listaVoos.addVoo(new Voo(origem, destino, dataVoo, aviao));
                    System.out.println("VOO CADASTRADO COM SUCESSO!!!");
            } catch (Exception e){
                    System.out.println("ERRO ao cadastrar voo");
                }//try-catch
   
        }else{
                System.out.println("So e permitido o cadastro de voo quando tiver pelo menos"
                + "um aviao cadastrado");
        }//fecha if-else
    
    }//fecha cadVoo
    
    
    public void showVoos(RepositorioVoos listaVoos){
 
        if(listaVoos.getListVoos().size() <=0){
           System.out.println("###################################");
           System.out.println("Nao existem voos cadastrados!!!!");
       }else{
           System.out.println("###################################\n");
           
           //formatacao para exibir voos
           
            for (Voo voo : listaVoos.getListVoos()) {
               System.out.println(String.format("%-10s", "ORIGEM DO VOO") + "\t"
                    + String.format("%-20s", "|DESTINO DO VOO") + "\t"
                    + String.format("%-15s", "|HORARIO DO VOO"));
                System.out.println(String.format("%-10s", voo.getOrigem()) + "\t"
                        + String.format("%-20s", "|" + voo.getDestino()) + "\t"
                        + String.format("%-15s", "|" + voo.getDataVoo()));
               
            System.out.println(voo.getAviao());
            System.out.println("=============================================\n");
            }//fecha for
             
            }//fechaif-else     
           
    }//fecha metodo
       
   public void searchVoo(RepositorioVoos listaVoo,RepositorioAvioes listaAvioes){
        if(listaVoo.getListVoos().size() > 0){
            int codigoAviao = Integer.parseInt(d.Digita("Informe o codigo do aviao: "));
                if(listaAvioes.AviaoExistByCod(codigoAviao) == false){
                    System.out.println("Aviao nao cadastrado!!!!");
                }else{
                    listaVoo.searchVooByAviao(listaAvioes.retornaAviao(codigoAviao));
                }//fecha-if-else
        }else{
            System.out.println("NAO EXISTEM VOOS CADASTRADOS");
        }//fecha if-else
    }//fecha metodo search
}//fecha classe
