/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Scanner;

/**
 *
 * @author Lucas Guasselli de Moraes
 * @version 1.0
 * @since 08/04/2017
 * 
 */
public class Digita {
    Scanner ler = new Scanner(System.in);
    
    public String digita(String texto){
            System.out.print(texto);
                  return ler.nextLine();
            }//fecha Digita
    
    public String digitaRg(String texto){
        String rg = "";
        int limit = 10;            
            do{
                System.out.print(texto);
                 rg = ler.nextLine();                         
            }while(rg.length() > limit || rg.length() <= 3);
                return rg;
    }//fecha Digita

    public String digitaNome(String texto) {
        String nome = "";
        int limit = 30;            
            do{
                System.out.print(texto);
                 nome = ler.nextLine();                         
            }while(nome.length() > limit || nome.length() <= 3);
                return nome;   
    }//fecha metodo

    public String digitaData(String texto) {
        String data = "00/00/0000";
        int limit = 10;            
            do{
                System.out.print(texto);
                    data = ler.nextLine();                         
            }while(data.length() > limit || data.length() < limit);
                return data;  
    
    }//fecha metodo
    
    public String digitaTelefone(String texto){
        String telefone = "(00)00000-0000";
        int limit = 14;            
            do{
                System.out.print(texto);
                    telefone = ler.nextLine();                         
            }while(telefone.length() > limit || telefone.length() < limit);
                return telefone;  
    }//fecha metodo
    
}//fecha classe
