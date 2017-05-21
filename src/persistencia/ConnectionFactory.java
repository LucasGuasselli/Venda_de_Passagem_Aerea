/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 8csm-guasselli
 */
public class ConnectionFactory {
   
        private static String url = "jdbc:postgresql://localhost:5432/postgres";
        private static String usuario = "postgres";
        private static String senha = "123456";
        
        public ConnectionFactory(){
        
        }//fecha construtor
    
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
       
            Class.forName("org.postgresql.Driver");
         
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
      
            if(conexao == null){
                System.out.println("Fala na conexao!");
            }else{
                System.out.println("Conectado com sucesso!");
            }//fecha -if-else
            
            //conexao.close();
            return conexao;
    }//fecha metodo
}//fecha classe
