/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author Lucas Guasselli de Moraes
 * @version 1.5
 * @since 19/04/2017
 * 
 */
public class Venda {
    //atributos
    private Cliente cliente;
    private Voo voo;
    private LocalDate horaCompra;
    
    //construtor
    public Venda(Cliente cliente, Voo voo){
        this.cliente = cliente;
        this.voo = voo;
        this.horaCompra = LocalDate.now();
        
    }//fecha construtor

    //metodos
    
    //SETS E GETS
    
    public void setVoo(Voo voo) {
        this.voo = voo;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    //TERMINA SET
    public Voo getVoo() {
        return voo;
    }

    public Cliente getCliente() {
        return cliente;
    }
   
    public LocalDate getHoraCompra() {
        return horaCompra;
    }
    
      //TERMINA GET
    
}//fecha classe
