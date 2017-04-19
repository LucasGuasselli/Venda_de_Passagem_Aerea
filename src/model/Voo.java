
package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Lucas Guasselli de Moraes
 * @version 1.4
 * @since 16/04/2017
 * 
 */
public class Voo {
    
    //atributos
    private String origem;
    private String destino;
    private LocalDate dataVoo;
    private Aviao aviao = null;
    
    
    DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    //construtor
    
    public Voo(String origem,String destino, String horarioVoo, Aviao aviao){
        this.origem = origem;
        this.destino = destino;
        this.dataVoo = LocalDate.parse(horarioVoo ,formatadorData);
        this.aviao = aviao;
        
    }//fecha construtor
    
    //metodos
    
    //SETS E GETS

    public void setOrigem(String origem) {
        this.origem = origem;
    }
    
    public void setDestino(String destino) {
        this.destino = destino;
    }
    public void setDataVoo(LocalDate dataVoo) {
        this.dataVoo = dataVoo;
    }
    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }
   
    //TERMINA SETS
    
    public String getOrigem() {
        return origem;
    }
    public String getDestino() {
        return destino;
    }
    public LocalDate getDataVoo() {
        return dataVoo;
    }
    public Aviao getAviao() {
        return aviao;
    }
    
    //TERMINA GETS
    
    @Override
    public String toString(){
        return  "\nOrigem: " + getOrigem()
               + "\nDestino: " + getDestino()
               + "\nHorario do voo: " + getDataVoo() 
               + "\nAviao: " + getAviao() + "\n";
    }//fecha toString
    
    
}//fecha classe
