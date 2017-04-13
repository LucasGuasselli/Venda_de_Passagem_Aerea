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
    
    public String Digita(String texto){
        Scanner ler = new Scanner(System.in);
             System.out.print(texto);
                  return ler.nextLine();
            }//fecha Digita
}//fecha classe
