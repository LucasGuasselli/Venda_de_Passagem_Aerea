/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import util.Opcao;
import util.Menu;
/**
 *
 * @author Lucas Guasselli de Moraes
 * @version 1.0
 * @since 08/04/2017
 * 
 */

public class MainUI {
    public static void main(String[] args) {
        
        //criando opcoes
        Opcao cadCli = new Opcao("Cadastrar cliente");
        Opcao verCli = new Opcao("Vizualizar cliente");
        
        Menu menu = new Menu();
        
        //adicionando opcoes ao menu
        menu.addOption(cadCli);
        menu.addOption(verCli);
        
        
        do{
            //mostra opcoes adicionadas no menu
            menu.show();
            
            switch(menu.getOption()){
                case 1:
                        
                    break;
                case 2:
                    
                    break;
                default:
                    
                    break;
            }//fecha switch-case
            
        }while(true);
        
    }//fecha main
}//fecha classe
