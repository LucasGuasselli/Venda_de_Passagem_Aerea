/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Aviao;
import model.Voo;
import repositorio.RepositorioAvioes;
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
    
    /*METODO QUE CADASTRA VOO
    * @param ArrayList RepositorioVoos
    * @param ArrayList RepositorioAvioes
    */
    public void cadVoo(RepositorioVoos listaVoos, RepositorioAvioes listaAvioes){
             //variaveis locais
        if(listaAvioes.getListAvioes().size() > 0){
            int limit = 30;
            String origem = "";
            String destino = "";
            String dataVoo = "";
            Aviao aviao = null;
            int codigoAviao = 0;
    
            origem = d.digitaNome("\n(min 3 e max 30 digitos)\nDigite o origem do voo: ");
        
            destino = d.digitaNome("\n(min 3 e max 30 digitos)\nDigite o destino do voo: ");
                 
        do{
            do{
                dataVoo = d.digitaData("\nDigite a data do voo no formato (dd/mm/aaaa):");
                    if(verifica.verificaDataAnterior(dataVoo) == true){
                        System.out.println("\nDigite uma data igual ou a partir da data atual");
                    }//fecha if
        }while(dataVoo.length() != 10 || verifica.verificaDataAnterior(dataVoo) == true);
            
            codigoAviao = Integer.parseInt(d.digita("\nInforme o codigo do aviao:"));
         
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
              listaVoos.addVoo(new Voo(origem, destino, dataVoo, aviao, aviao.getQtdeAssentos()));
                    System.out.println("VOO CADASTRADO COM SUCESSO!!!");
            } catch (Exception e){
                    System.out.println("ERRO ao cadastrar voo");
                }//try-catch
   
        }else{
                System.out.println("So e permitido o cadastro de voo quando tiver pelo menos"
                + "um aviao cadastrado");
        }//fecha if-else
    
    }//fecha cadVoo
    
    //METODO QUE MOSTRA OS VOOS CADASTRADOS
    //@param ArrayList RepositorioVoos

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
     /*METODO QUE VERIFICA SE UM VOO ESTA CADASTRADO
    *@param ArrayList o tipo RepositorioVoos
    *@param ArrayList o tipo RepositorioAvioes
    */
   public void searchVoo(RepositorioVoos listaVoo,RepositorioAvioes listaAvioes){
        if(listaVoo.getListVoos().size() > 0){
            int codigoAviao = Integer.parseInt(d.digita("Informe o codigo do aviao: "));
                if(listaAvioes.AviaoExistByCod(codigoAviao) == false){
                    System.out.println("Aviao nao cadastrado!!!!");
                }else{
                    listaVoo.searchVooByAviao(listaAvioes.retornaAviao(codigoAviao));
                }//fecha-if-else
        }else{
            System.out.println("NAO EXISTEM VOOS CADASTRADOS");
        }//fecha if-else
    }//fecha metodo search
    
    /*METODO QUE VERIFICA MOSTRA TODOS OS ASSENTOS DO VOO
    *@param ArrayList o tipo RepositorioVoos
    *@param ArrayList o tipo RepositorioAvioes
    */
    public void verAssentos(RepositorioVoos listaVoos,RepositorioAvioes listaAvioes) {
        int codigoAviao;
        String dataVoo;
        Voo voo = null;
         do{
            codigoAviao = Integer.parseInt(d.digita("\nInforme o codigo do aviao:"));
            dataVoo = d.digita("Informe a data do voo: ");
             
                if(listaAvioes.AviaoExistByCod(codigoAviao) == true){
                    if(listaVoos.verificaAviaoData(dataVoo,listaAvioes.retornaAviao(codigoAviao)) == true){
                        voo = listaVoos.retornaVoo(listaAvioes.retornaAviao(codigoAviao));
                    }else{
                        System.out.println("Aviao nao possui voo para esta data!"); 
                    }                                           
                }else{
                    System.out.println("AVIAO NAO EXISTE");
                }
               }while(voo == null);
         voo.toString();
         voo.mostraAssentos();
    
    }//fecha metodo
    
}//fecha classe
