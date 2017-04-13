/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import javax.swing.JOptionPane;
import util.Opcao;
import util.Menu;
import repositorio.RepositorioClientes;
/**
 *
 * @author Lucas Guasselli de Moraes
 * @version 1.0
 * @since 08/04/2017
 * 
 */

public class MenuUI {
    public void executar(){        
      
        //criando opcoes
        Opcao cadCli = new Opcao("Cadastrar cliente");
        Opcao verCli = new Opcao("Vizualizar cliente");
        Opcao pesquisaCliRg = new Opcao("Pesquisa cliente pelo RG");
        Opcao sair = new Opcao("Sair");
        
        Menu menu = new Menu();
        
        //adicionando opcoes ao menu
        menu.addOption(cadCli);
        menu.addOption(verCli);
        menu.addOption(pesquisaCliRg);
        menu.addOption(sair);
        
        RepositorioClientes listaClientes = new RepositorioClientes();
        ClienteUI cliUI = new ClienteUI();
        int opcao;
       
        try{
        do{
            //mostra opcoes adicionadas no menu
            menu.show();
            opcao = menu.getOption();
            switch(opcao){
                case 1:
                        cliUI.cadCliente(listaClientes);
                    break;
                case 2:
                        cliUI.showClientes(listaClientes);
                    break;
                case 3:
                        cliUI.searchCliente(listaClientes);
                    break;
                case 0:
                        System.out.println("Aplicacao finalizada!!!");
                    break;
                default:
                    System.out.println("Digite uma opcao valida!!!");
                    break;
            }//fecha switch-case
            
        }while(opcao != 0);
            }catch (Exception e){
                System.out.println("USO SOMENTE DE NUMEROS INTEIROS PARA NAVEGAR NO MENU!");
            }//fecha try-catch
    }//fecha executar
}//fecha classe
