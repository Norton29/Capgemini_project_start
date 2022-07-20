
package util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author norton
 */
public class ConnectionFactory {
    
    public static final String DRIVER ="com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://172.17.0.2:3306/projeto_capgemini_start";
    public static final String USER = "root";
    public static final String PASS = "root";
    
    public static Connection getConnection(){
        try{
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        }catch(ClassNotFoundException | SQLException e){
            throw new RuntimeException("Erro na conexão com o banco de dados", e);
            
        }
    }
    
    public static void closeConnection(Connection connection){
        try {
            if(connection!=null){
            connection.close();    
            }            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao encerrar conexão com banco de dados", ex);
         }
    }
    
    public static void closeConnection(Connection connection, 
            PreparedStatement preparedStatement){
        try {
            if(connection!=null){
            connection.close();    
            }     
            
            if(preparedStatement != null){
                preparedStatement.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao encerrar conexão com banco de dados", ex);
         }
    }
    
    public static void closeConnection(Connection connection, 
            PreparedStatement preparedStatement, 
            ResultSet resultSet){
        try {
            if(connection!=null){
            connection.close();    
            }     
            
            if(preparedStatement != null){
                preparedStatement.close();
            }
            
            if(resultSet != null){
                resultSet.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao encerrar conexão com banco de dados", ex);
         }
    }
            
        
    
}
