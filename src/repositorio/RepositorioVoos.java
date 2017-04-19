/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import model.Aviao;
import model.Voo;

/**
 *
 * @author Lucas Guasselli de Moraes
 * @version 1.3
 * @since 13/04/2017
 * 
 */
public class RepositorioVoos {
     private List<Voo> voos;
    
    //construtor ja instanciando um novo ArrayList
    public RepositorioVoos() {
        voos = new ArrayList<Voo>();
    }//fecha construtor

    //metodos
    
    //adiciona voo no Array
    public boolean addVoo(Voo voo) {
        return (voos.add(voo));
    }//fecha addPaciente

    //mostra os voos cadastrados no Array
    public List<Voo> getListVoos() {
        return voos;
    }//fecha get

    /*
    *Verifica se o voo existe por meio do atributo aviao relacionado
    *Se o voo ja existir, return TRUE, se não return FALSE;
    */
    public boolean vooExist(Aviao aviao) {
        for (Voo voo : voos) {
            if (voo.getAviao() == aviao) {
                return true;
            }//fecha if
        }//fecha for-each
        return false;
    }//fecha clienteExist

    /*
    *Procura voos existentes no Array pelo seu aviao relacionado
    *se a condicao for verdadeira, retorna o objeto VOO, se nao retorna NULL
    */
    public boolean searchVooByAviao(Aviao aviao) {
        for (Voo voo : voos) {
            if (voo.getAviao() == aviao) {
                System.out.println("###################################\n");
                            
                System.out.println(String.format("%-10s", "ORIGEM DO VOO") + "\t"
                   + String.format("%-20s", "|DESTINO DO VOO") + "\t"
                   + String.format("%-15s", "|HORARIO DO VOO"));
                System.out.println(String.format("%-10s", voo.getOrigem()) + "\t"
                   + String.format("%-20s", "|" + voo.getDestino()) + "\t"
                    + String.format("%-15s", "|" + voo.getDataVoo()));
               
                System.out.println(voo.getAviao());
                System.out.println("=============================================\n");
          
                    return true;
           }else{
                System.out.println("AVIAO NAO POSSUI VOOS CADASTRADOS!!!");
            }
            
        }//fecha for
        return false;
      
    }//fecha searchCliente
    
    //metodo que serve para verificar se os voos possuem o mesmo aviao
    public boolean verificaAviao(Aviao aviao){
        for(Voo voo : voos){
            if(voo.getAviao() == aviao){
                return true;
            }//fecha if
        }//fecha for
        return false;
    }//fecha metodo
    
    public boolean verificaDataVoos(String data){
        DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataX = LocalDate.parse(data,formatadorData);
        int soma;     
        
        for(Voo voo : voos) { 
            Period periodo = Period.between(voo.getDataVoo(), dataX);
            soma = (periodo.getYears() + periodo.getMonths() + periodo.getDays());
        
        if(soma <= -1 || soma >= 1){
                return true;
            }//fecha if
            
        }//fecha for-each
        return false;
    }//fecha metodo
    
}//fecha classe
