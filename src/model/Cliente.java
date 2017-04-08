/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author lucas
 */
public class Cliente {
    
    //atributos
    private String nome;
    private int RG;
    private String telefone;
    
    //construtor
    
    public Cliente(String nome, int RG, String telefone){
        this.nome = nome;
        this.RG = RG;
        this.telefone = telefone;
        
    }//fecha construtor
    
    //metodos
    
    //SETS E GETS
    
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setRG(int RG){
        this.RG = RG;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    public String getNome(){
        return this.nome;
    }
    public int getRG(){
        return this.RG;
    }
    public String getTelefone(){
        return this.telefone;
    }
    
    
    @Override
    public String toString(){
        return  "\nNome: " + getNome()
               + "\nRG: " + getRG()
               + "\nTelefone: " + getTelefone() + "\n";
    }//fecha toString
}//fecha classe
