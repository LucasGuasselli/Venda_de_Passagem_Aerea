/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import repositorio.RepositorioAvioes;
import util.Menu;
import util.Opcao;

/**
 *
 * @author Lucas Guasselli de Moraes
 * @version 1.3
 * @since 13/04/2017
 * 
 */
public class MenuAviaoUI  {

    //atributos
    
    Opcao cadAvi = new Opcao("Cadastrar aviao");
    Opcao verAvi = new Opcao("Visualizar avioes");  
    Opcao pesquisarAviByCod = new Opcao("Pesquisar aviao pelo codigo");
    Opcao menuPrincipal = new Opcao("Voltar ao menu principal");

    Menu menu = new Menu();
    
    private RepositorioAvioes lista;
    int opcao;
    
    AviaoUI aviaoUI = new AviaoUI();
    
    public MenuAviaoUI(RepositorioAvioes lista) {
        this.lista = lista;
        menu.addOption(cadAvi);
        menu.addOption(verAvi);
        menu.addOption(pesquisarAviByCod);
        menu.addOption(menuPrincipal);
    }//fecha construtor
    
    
    public void menuAviao(){ 
        try{   
        do{
                 //mostra opcoes adicionadas no menu
                menu.show();
                opcao = menu.getOption();
                 switch(opcao){
                    case 1:
                        aviaoUI.cadAviao(lista);
                        break;
                    case 2:
                        aviaoUI.showAvioes(lista);
                        break;
                    case 3:
                        aviaoUI.searchAviao(lista);
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
        }//fecha metodo menuaVIAO    
    
    
}//fecha classe
