/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Lucas Guasselli de Moraes
 * @version 1.0
 * @since 08/04/2017
 * 
 */
public class Cliente {
    
    //atributos
    private String nome;
    private String rg;
    private String telefone;
    
    //construtor
    
    public Cliente(String nome,String rg, String telefone){
        this.nome = nome;
        this.rg = rg;
        this.telefone = telefone;
        
    }//fecha construtor
    
    //metodos
    
    //SETS E GETS
    
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setRg(String rg){
        this.rg = rg;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    //TERMINAR SETS
    
    public String getNome(){
        return this.nome;
    }
    public String getRg(){
        return this.rg;
    }
    public String getTelefone(){
        return this.telefone;
    }
     //TERMINA GETS
    
    @Override
    public String toString(){
        return  "\nNome: " + getNome()
               + "\nRG: " + getRg()
               + "\nTelefone: " + getTelefone() + "\n";
    }//fecha toString
}//fecha classe
