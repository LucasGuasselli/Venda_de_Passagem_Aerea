/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Cliente;
import persistencia.ConnectionFactory;


/**
 *
 * @author 631520359
 */
public class ClienteDAO {
    public void cadastrarCliente(Cliente cliente) throws SQLException, ClassNotFoundException{
        
        //CADASTRANDO Cliente
        
        Connection conexao = ConnectionFactory.getConnection();
        
        
            String sql = "insert into cliente(nome, rg, telefone) values (?, ?, ?)";
                PreparedStatement comando = conexao.prepareStatement(sql);
                    comando.setString(1,cliente.getNome());
                    comando.setString(2,cliente.getRg());
                    comando.setString(3,cliente.getTelefone());
                    
                 if(comando.executeUpdate()>0){
                     System.out.println("Cadastro realizado com sucesso!");
                 }//fecha if
                
            conexao.close();     
    }//fecha cadastrarPessoa
}//fecha classe
