
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import persistencia.ConnectionFactory;

/**
 *
 * @author Lucas Guasselli de Moraes
 * @version 1.6
 * @since 20/05/2017
 * 
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
                     System.out.println("\nCadastro realizado com sucesso!");
                 }//fecha if
        }catch (SQLException e) {
                 throw new SQLException("\nErro ao cadastrar cliente!");
        } finally {
            conexao.close();
            comando.close();
        }//fecha finally           
    }//fecha cadastrarPessoa
        
    public void editarCliente(Cliente cliente) throws SQLException, ClassNotFoundException{
        try{
            String sql = "UPDATE cliente SET nome=?, rg=?, telefone=? "
                    + "WHERE idCliente=?";

            conectar(sql);
            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getRg());
            //Trabalhando com data: convertendo LocalDate -> Date
            //Date dataSql = Date.valueOf(paciente.getDataNascimento());
            comando.setString(3, cliente.getTelefone());
            comando.setInt(4, cliente.getId());
            comando.executeUpdate();      
        }catch (SQLException e) {
                 throw new SQLException("\nErro ao editar cliente!");
        } finally {
            conexao.close();
            comando.close();
        }//fecha finally
    }//fecha editarCliente
    
    public void deletarCliete(Cliente cliente) throws SQLException, ClassNotFoundException{
        
        //DELETANDO CLIENTE
        try{
                String sql = "delete from cliente where idCliente = ?";
                    conectar(sql); 
                    
                comando.setInt(1,cliente.getId());
                 if(comando.executeUpdate()>0){
                     System.out.println("\nCliente deletado com sucesso!");
                 }//fecha if
        }catch (SQLException e) {
                 throw new SQLException("\nErro ao deletar cliente!");
        } finally {
            conexao.close();
            comando.close();
        }//fecha finally            
    }//fecha deletarCliente
    
    public Cliente retornaClientePorRg(String _rg) throws SQLException, ClassNotFoundException {
        
        try{
            String sql = "SELECT * FROM cliente WHERE rg = ?";
      
            conectar(sql);
            comando.setString(1, _rg);

            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                int id = resultado.getInt("idCliente");
                String nome = resultado.getString("nome");
                String rg = resultado.getString("rg");
                String telefone = resultado.getString("telefone");
                
                Cliente cli = new Cliente(id, rg, nome, telefone);

                return cli;
            }//fecha if
        }catch (SQLException e) {
                 throw new SQLException("\nErro ao procurar cliente!");
        } finally {
            conexao.close();
            comando.close();
        }//fecha finally
                return (null);
    }//fecha procurarPorRg
     
    public List<Cliente> retornaClientePorNome(String _nome) throws ClassNotFoundException, SQLException {
        List<Cliente> listaClientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente WHERE nome LIKE ?";

        try {
            conectar(sql);
            comando.setString(1, "%" + _nome + "%");
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("idCliente");
                String nome = resultado.getString("nome");
                String rg = resultado.getString("rg");
                String telefone = resultado.getString("telefone");               

                Cliente cli = new Cliente(id, rg, nome, telefone);
                    listaClientes.add(cli);                    
            }//fecha while
            return listaClientes;
        }catch (SQLException e) {
                 throw new SQLException("\nErro ao procurar cliente!");
        } finally {
            conexao.close();
            comando.close();
        }//fecha finally
    }//fecha metodo listarPorNome
    
    public Cliente retornaClientePorId(int _id)throws SQLException, ClassNotFoundException {
        try{
            String sql = "SELECT * FROM cliente WHERE idCliente = ?";
            conestar(sql);       
            comando.setInt(1,_id);
            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                int id = resultado.getInt("idCliente");
                String nome = resultado.getString("nome");
                String rg = resultado.getString("rg");
                String telefone = resultado.getString("telefone");
                
                Cliente cli = new Cliente(id, nome, rg, telefone);

                return cli;
            }//terminar caminho feliz (IF)
        }catch (SQLException e) {
                 throw new SQLException("\nErro ao procurar cliente!");
        } finally {
            conexao.close();
            comando.close();
        }//fecha finally        
        return (null);
    }//fecha metodo procurarPorId
       
    public List<Cliente> retornaListaClientes() throws ClassNotFoundException, SQLException {
        List<Cliente> listaClientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try {
            conectar(sql);
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("idCliente");
                String nome = resultado.getString("nome");
                String rg = resultado.getString("rg");
                String telefone = resultado.getString("telefone");               

                Cliente cli = new Cliente(id, rg, nome, telefone);
                    listaClientes.add(cli);                    
            }//fecha while
            return listaClientes;
        }catch (SQLException e) {
                 throw new SQLException("\nErro ao procurar cliente!");
        } finally {
            conexao.close();
            comando.close();
        }//fecha finally    
    }//fecha listarClientes

    public boolean verificaClienteRg(String _rg) throws ClassNotFoundException, SQLException {
        try{
            String sql = "SELECT * FROM cliente WHERE rg = ?";      
                conectar(sql);
                comando.setString(1, _rg);
            ResultSet resultado = comando.executeQuery();
                if (resultado.next()) {                
                    return true;
                }//fecha if
        }catch (SQLException e) {
                throw new SQLException("\nErro ao verificar cliente!");
        } finally {
            conexao.close();
            comando.close();
        }//fecha finally
                return false;   
    }//fecha verificaRG

    public boolean verificaClienteNome(String _nome) throws ClassNotFoundException, SQLException {
        try{
            String sql = "SELECT * FROM cliente WHERE nome = ?";      
                conectar(sql);
                comando.setString(1, "%" + _nome + "%");
            ResultSet resultado = comando.executeQuery();
                if (resultado.next()) {                
                    return true;
                }//fecha if
        }catch (SQLException e) {
                throw new SQLException("\nErro ao verificar cliente!");
        } finally {
            conexao.close();
            comando.close();
        }//fecha finally
                return false; 
    }//fecha metodo verificaNome
     
    public boolean verificaExistCliente() throws SQLException, ClassNotFoundException {
        try{
            String sql = "SELECT * FROM cliente";      
                conectar(sql);
            ResultSet resultado = comando.executeQuery();
                if(resultado.next()) {                
                    return true;
                }//fecha if
        }catch (SQLException e) {
                throw new SQLException("\nErro ao verificar cliente!");
        } finally {
            conexao.close();
            comando.close();
        }//fecha finally
                   return false;   
    }//fecha verificaExistCliente
}//fecha classe



        
            
