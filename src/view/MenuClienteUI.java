/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import static java.awt.SystemColor.menu;
import repositorio.RepositorioClientes;
import util.Menu;
import util.Opcao;

/**
 *
 * @author Lucas Guasselli de Moraes
 * @version 1.3
 * @since 13/04/2017
 * 
 */
public class MenuClienteUI {
    
      
        Opcao cadCli = new Opcao("Cadastrar cliente");
        Opcao verCli = new Opcao("Vizualizar clientes");
        Opcao pesquisaCliRg = new Opcao("Pesquisa cliente pelo RG");
        Opcao menuPrincipal = new Opcao("Voltar ao menu principal");
        
        Menu menu = new Menu();
       
       
        private RepositorioClientes lista;
        int opcao;
        
        ClienteUI cliUI = new ClienteUI();
        
        //construtor
        public MenuClienteUI(RepositorioClientes lista) {
           this.lista = lista;
           menu.addOption(cadCli);
           menu.addOption(verCli);
           menu.addOption(pesquisaCliRg);
           menu.addOption(menuPrincipal);
        }//fecha construtor
        
        public void menuCliente(){
            do{
                 //mostra opcoes adicionadas no menu
                menu.show();
                opcao = menu.getOption();
                 switch(opcao){
                    case 1:
                        cliUI.cadCliente(lista);
                        break;
                    case 2:
                        cliUI.showClientes(lista);
                        break;
                    case 3:
                        cliUI.searchCliente(lista);
                        break;
                    case 0:
                        System.out.println("Retornando ao menu principal");
                        break;
                default:
                    System.out.println("Digite uma opcao valida!!!");
                        break;
            }//fecha switch-case            
        }while(opcao != 0);
            
        }//fecha metodo menuCliente
}//fecha classe
