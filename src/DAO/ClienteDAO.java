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
import model.Cliente;
import persistencia.ConnectionFactory;


/**
 *
 * @author 631520359
 */
public class ClienteDAO {
    
    private Connection conexao;
    private PreparedStatement comando;

    public Connection conectar(String sql) throws SQLException, ClassNotFoundException {
        conexao = ConnectionFactory.getConnection();
        comando = conexao.prepareStatement(sql);
        return conexao;
    }//fecha conectar
    
    
    public void cadastrarCliente(Cliente cliente) throws SQLException, ClassNotFoundException{
        
        //CADASTRANDO Cliente
        
            try{   
            String sql = "insert into cliente(nome, rg, telefone) values (?, ?, ?)";
               conectar(sql);
                    comando.setString(1,cliente.getNome());
                    comando.setString(2,cliente.getRg());
                    comando.setString(3,cliente.getTelefone());
                    
                 if(comando.executeUpdate()>0){
                     System.out.println("Cadastro realizado com sucesso!");
                 }//fecha if
            }catch (SQLException e) {
                 throw new SQLException("Erro ao cadastrar cliente!");
            } finally {
            conexao.close();
            comando.close();
        }//fecha finally
   
            
    }//fecha cadastrarPessoa
    
    
     public void editarCliente(Cliente cliente) throws SQLException, ClassNotFoundException{
        try{
            String sql = "UPDATE cliente SET nome=?, rg=?, telefone=? "
                    + "WHERE id=?";

            conectar(sql);
            comando.setString(1, cliente.getRg());
            comando.setString(2, cliente.getNome());
            //Trabalhando com data: convertendo LocalDate -> Date
            //Date dataSql = Date.valueOf(paciente.getDataNascimento());
            comando.setString(3, cliente.getTelefone());
            comando.setInt(4, cliente.getId());
            comando.executeUpdate();      
            }catch (SQLException e) {
                 throw new SQLException("Erro ao editar produto!");
            } finally {
            conexao.close();
            comando.close();
        }//fecha finally
    }//fecha editarCliente
     
     public Cliente procurarPorRg(String _rg) throws SQLException, ClassNotFoundException {
        
         try{
            String sql = "SELECT * FROM cliente WHERE rg = ?";
      
            conectar(sql);
            comando.setString(1, _rg);

            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                String rg = resultado.getString("rg");
                String telefone = resultado.getString("nome");
                //Trabalhando com data: convertendo dataSql -> LocalDate
                //Date dataSql = resultado.getDate("datanascimento");
                //LocalDate dataNascimento = dataSql.toLocalDate();

                Cliente cli = new Cliente(id, rg, nome, telefone);

                return cli;
            }//fecha if
             }catch (SQLException e) {
                 throw new SQLException("Erro ao procurar cliente!");
            } finally {
            conexao.close();
            comando.close();
            }//fecha finally
                return (null);
    }//fecha procurarPorRg
     
     
}//fecha classe
