/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

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
        Opcao edtCli = new Opcao("Editar clientes");
        Opcao delCli = new Opcao("Deletar clientes");
        Opcao pesquisaCliRg = new Opcao("Pesquisa cliente pelo RG");
        Opcao pesquisaCliNome = new Opcao("Pesquisa cliente pelo NOME");
        Opcao verCli = new Opcao("Vizualizar clientes");       
        Opcao menuPrincipal = new Opcao("Voltar ao menu principal");
        
        Menu menu = new Menu();
       
       
        private RepositorioClientes lista;
        int opcao;
        
        ClienteUI cliUI = new ClienteUI();
        
        //construtor
        public MenuClienteUI(RepositorioClientes lista) {
           this.lista = lista;
           menu.addOption(cadCli);
           menu.addOption(edtCli);
           menu.addOption(delCli);
           menu.addOption(pesquisaCliRg);
           menu.addOption(pesquisaCliNome);
           menu.addOption(verCli);
           menu.addOption(menuPrincipal);
        }//fecha construtor
        
        public void menuCliente(){
            try{
            do{
                 //mostra opcoes adicionadas no menu
                menu.show();
                opcao = menu.getOption();
                 switch(opcao){
                    case 1:
                        cliUI.cadCliente();
                        break;
                    case 2:
                        cliUI.editaCliente();
                        break;
                    case 3:
                        cliUI.deletaCliente();
                        break;
                     case 4:
                        cliUI.procurarPorRg();
                        break;
                    case 5:
                        cliUI.procurarClientesPorNome();
                        break;
                    case 6:

                        break;
                    case 0:
                        System.out.println("Retornando ao menu principal");
                        break;
                default:
                    System.out.println("Digite uma opcao valida!!!");
                        break;
            }//fecha switch-case            
        }while(opcao != 0);
            }catch (Exception e){
                System.out.println("USO SOMENTE DE NUMEROS INTEIROS PARA NAVEGAR NOS MENUS!");
            }//FECHA TRY-CATCH
        }//fecha metodo menuCliente
}//fecha classe
