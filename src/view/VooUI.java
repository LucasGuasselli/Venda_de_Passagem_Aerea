/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DAO.AviaoDAO;
import DAO.VooDAO;
import java.sql.SQLException;
import java.util.List;
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
    private VooDAO vDAO = new VooDAO();
    private AviaoDAO aDAO = new AviaoDAO();
    private Digita d = new Digita();
    private VerificaDatas verifica = new VerificaDatas();
    
    /*METODO QUE CADASTRA VOO
    * @param ArrayList RepositorioVoos
    * @param ArrayList RepositorioAvioes
    */
    public void cadVoo() throws SQLException, ClassNotFoundException{
             //variaveis locais
        if(aDAO.verificaExistAviao() == true){
            int limit = 30;
            String origem = "";
            String destino = "";
            String dataVoo = "";
            Aviao aviao = null ;
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
            
            codigoAviao = (d.digitaCodigo("\nInforme o codigo do aviao:"));
         
        if(aDAO.verificaAviaoByCod(codigoAviao) == true){
            if( vDAO.verificaDataAviao(codigoAviao,dataVoo) == false){
                aviao = (aDAO.procurarAviaoByCod(codigoAviao));
            }else{
                System.out.println("Aviao ja possui um voo nessa data");
            }
        }else{
            System.out.println("Aviao nao cadastrado!!");
        } 
        }while(aviao == null);
               
        try{
            vDAO.cadastrarVoo (new Voo(origem, destino, dataVoo, aviao));
                    System.out.println("VOO CADASTRADO COM SUCESSO!!!");
            } catch (Exception e){
                    System.out.println("ERRO ao cadastrar voo");
                }//try-catch
   
        }else{
                System.out.println("So e permitido o cadastro de voo quando tiver pelo menos"
                + "um aviao cadastrado");
        }//fecha if-else
    
    }//fecha cadVoo
    
    public void visualizarVoos() throws ClassNotFoundException, SQLException {
        List<Voo> listaVoos = vDAO.listarVoos();
                mostrarVoos(listaVoos);        
    }//fecha visualizarClientes

    public void pesquisaVooPorAviao(AviaoUI aviaoui) throws SQLException, ClassNotFoundException {
        if(aDAO.verificaExistAviao() == true){
            List<Aviao> listaAvioes = aDAO.listarAvioes();
                aviaoui.mostrarAvioes(listaAvioes);
                int id = Integer.parseInt(d.digita("\nInforme o ID do aviao: "));
               List<Voo> listaVoos = vDAO.listarVoos(id);
                    mostrarVoos(listaVoos);
        }else{
                System.out.println("So e permitido a pesquisa de voo quando tiver pelo menos"
                + "um aviao cadastrado");
        }//fecha if-else
    }//fecha pesquisaVooPorAviao
    
    private void mostrarVoos(List<Voo> listaVoos) {
        if (listaVoos.isEmpty()) {
            System.out.println("\nVoo(s) nao encontrado(s)!");
        } else {
            System.out.println("###################################\n");
           
            System.out.println(String.format("%-10s", "ORIGEM") + "\t"
                    + String.format("%-20s", "|DESTINO") + "\t"
                    + String.format("%-20s", "|DATA") + "\t"
                    + String.format("%-15s", "|ID DO AVIAO"));
            for (Voo voo : listaVoos) {
                System.out.println(String.format("%-10s", voo.getOrigem()) + "\t"
                        + String.format("%-20s", "|" + voo.getDestino()) + "\t"
                        + String.format("%-20s", voo.getDataVoo()) + "\t"
                        + String.format("%-15s", "|" + voo.getIdAviao()));
            }//fea for
        }//fecha if-else 
    }//fecha mostrarVoos
    
    public void mostrarVoo(Voo voo){
 
        System.out.println("###################################\n");           
           //formatacao para exibir voos
           System.out.println(String.format("%-10s", "ORIGEM") + "\t"                    
                    + String.format("%-20s", "DESTINO") + "\t"
                    + String.format("%-20s", "|DATA DO VOO") + "\t"
                    );
        
            System.out.println(String.format("%-10s", voo.getOrigem()) + "\t"
                    + String.format("%-20s", "|" + voo.getDestino() + "\t"
                    + String.format("%-20s", voo.getDataVoo()) + "\t"
                    ));          
    }//fecha método
    
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
