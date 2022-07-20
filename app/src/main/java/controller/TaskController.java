/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import model.Task;
import util.ConnectionFactory;

/**
 *
 * @author norton
 */
public class TaskController {
    
        Connection connection;
        PreparedStatement preparedStatement;
    
    public void save(Task task){
        
       
    }
    
    public void update(Task task){
        
    }
    
    public void deleteById(int taskId){
        String sql = "DELETE FROM tasks WHERE id = ?";
        
        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
        } catch (Exception e) {
            
        }
    }
    
    public List<Task> getAll(int idProject){
        
        return null;
        
    }
    
    
}
