/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import model.Assento;
import model.Voo;
import persistencia.ConnectionFactory;

/**
 *
 * @author Lucas Guasselli de Moraes
 * @version 1.8
 * @since 01/06/2017
 * 
 */
public class AssentosDAO {
    //atributos
   private AviaoDAO aDAO = new AviaoDAO();
    private Connection conexao;
    private PreparedStatement comando;
    DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Connection conectar(String sql) throws SQLException, ClassNotFoundException {
        conexao = ConnectionFactory.getConnection();
        comando = conexao.prepareStatement(sql);
        return conexao;
    }//fecha conectar
    
    public void cadastrarAssento(Voo voo,int _numAssento) throws SQLException, ClassNotFoundException{
    
    //CADASTRANDO ASSENTOS       
        try{          
            String sql = "insert into assentos(idVoo,disponibilidade, numAssento) values(?, ?, ?)";
               conectar(sql);
                    comando.setInt(1,voo.getIdVoo());
                    comando.setBoolean(2,false);           
                    comando.setInt(3,_numAssento);
                    comando.executeUpdate();
               
        }catch (SQLException e) {
                 throw new SQLException("\nErro ao cadastrar assentos!");
        } finally {
            conexao.close();
            comando.close();
        }//fecha finally
    }//fecha cadastraAssentos
       
    public Assento retornaAssento(Voo voo, int _numAssento) throws ClassNotFoundException, SQLException {
        Assento assento = null;
        String sql = "SELECT * FROM assentos WHERE idVoo = ? and numAssento = ?";
        try {
            conectar(sql);
            comando.setInt(1,voo.getIdVoo());
            comando.setInt(2,_numAssento);

            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                int idVoo = resultado.getInt("idVoo");
                boolean disponibilidade = resultado.getBoolean("disponibilidade");
                int numAssento = resultado.getInt("numAssento");
     
                assento = new Assento(idVoo,numAssento, disponibilidade);                                 
            }//fecha while
            return assento;
        }catch (SQLException e) {
                 throw new SQLException("\nErro ao procurar assento!");
        } finally {
            conexao.close();
            comando.close();
        }//fecha finally   
    }//fecha listarAssento
    
    
}//fecha classe
