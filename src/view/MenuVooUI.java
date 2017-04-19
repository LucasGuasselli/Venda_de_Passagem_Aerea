/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import repositorio.RepositorioAvioes;
import repositorio.RepositorioVoos;
import util.Menu;
import util.Opcao;

/**
 *
 * @author Lucas Guasselli de Moraes
 * @version 1.4
 * @since 16/04/2017
 * 
 */
public class MenuVooUI {
        Opcao cadVoo = new Opcao("Cadastrar voo");
        Opcao verVoo = new Opcao("Vizualizar voos");
        Opcao pesquisaVooByAviao = new Opcao("Pesquisa voo pelo aviao");
        Opcao menuPrincipal = new Opcao("Voltar ao menu principal");
        
        Menu menu = new Menu();
       
       
        private RepositorioVoos listaVoos;
        private RepositorioAvioes listaAvioes;
        int opcao;
        
        VooUI VooUI = new VooUI();
        
        //construtor
        public MenuVooUI(RepositorioVoos listaVoos, RepositorioAvioes listaAvioes) {
           this.listaVoos = listaVoos;
           this.listaAvioes = listaAvioes;
           menu.addOption(cadVoo);
           menu.addOption(verVoo);
           menu.addOption(pesquisaVooByAviao);
           menu.addOption(menuPrincipal);
        }//fecha construtor
        
        public void menuVoo(){
            do{
                 //mostra opcoes adicionadas no menu
                menu.show();
                opcao = menu.getOption();
                 switch(opcao){
                    case 1:
                        VooUI.cadVoo(listaVoos, listaAvioes);
                        break;
                    case 2:
                        VooUI.showVoos(listaVoos);
                        break;
                    case 3:
                        VooUI.searchVoo(listaVoos ,listaAvioes);
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
