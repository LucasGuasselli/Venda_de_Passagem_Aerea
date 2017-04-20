
package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import util.Digita;

/**
 *
 * @author Lucas Guasselli de Moraes
 * @version 1.4
 * @since 16/04/2017
 * 
 */
public class Voo {
    
    //atributos
    private Digita d = new Digita();
    private String origem;
    private String destino;
    private LocalDate dataVoo;
    private Aviao aviao = null;
  
    private  boolean[] controlaAssentos; 
    private int meuAssento = 0;
    
    DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    //construtor
    
    public Voo(String origem,String destino, String horarioVoo, Aviao aviao, int quantidade){
        this.origem = origem;
        this.destino = destino;
        this.dataVoo = LocalDate.parse(horarioVoo ,formatadorData);
        this.aviao = aviao;
        this.controlaAssentos = new boolean[quantidade];
       
        
    }//fecha construtor
    
    //metodos
    
      
    public void mostraAssentos(){
        System.out.println("Quantidade de assentos: " + aviao.getQtdeAssentos());
        for(int i = 0; i < controlaAssentos.length;i++){
            if(controlaAssentos[i] == true){
                System.out.println("Assento " + (i+1)+ ": " + "Ocupado");
            }else{
                System.out.println("Assento " + (i+1)+ ": " + "Disponivel");
            }//fecha if-else    
        }//fecha for
            
    }//fecha metodo
    
    public void mostraAssentosDisponiveis(){
        for(int i = 0; i < controlaAssentos.length;i++){
            if(controlaAssentos[i] == false){
                System.out.println("Assento " + (i+1)+ ": " + "Disponivel");
            }//fecha if   
        }//fecha for
    }//fecha classe
    
   public void reservaAssento(){
      int assento;
      boolean loop = true;
        mostraAssentosDisponiveis();
            do{
            assento = Integer.parseInt(d.digita("Selecione o assento desejado: "));
                if(controlaAssentos[assento-1] == false){
                    controlaAssentos[assento-1] = true;
                    setMeuAssento(assento);
                    System.out.println("Assento reservado!");
                    loop = false;
                }else{
                    System.out.println("selecione um assento disponivel!");
                }//fecha if-else
            }while(loop == true);
   }//fecha metodo
   
    //SETS E GETS

    public void setControlaAssentos(boolean[] controlaAssentos) {
        this.controlaAssentos = controlaAssentos;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public void setMeuAssento(int meuAssento) {
        this.meuAssento = meuAssento;
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
    
    public boolean[] getControlaAssentos() {
        return controlaAssentos;
    }

    public String getOrigem() {
        return origem;
    }

    public int getMeuAssento() {
        return meuAssento;
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
        return  (String.format("%-10s", "ORIGEM") + "\t"
                   + String.format("%-20s", "|DESTINO") + "\t"
                      + String.format("%-15s", "|DATA VOO"))
              + "\n" + ((String.format("%-10s", getOrigem()) + "\t"
                        + String.format("%-20s", "|" + getDestino()) + "\t"
                         + String.format("%-15s", "|" + getDataVoo()))) + "\n"
                          +  getAviao();
        }//fecha toString
    
    
}//fecha classe
