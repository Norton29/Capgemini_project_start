/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        ResultSet resultSet;
    
    public void save(Task task) throws SQLException{
        String sql = "INSERT INTO tasks (name,"
                + " description, "
                + "completed,"
                + "notes,"
                + "deadline,"
                + "created_date,"
                + "update_date,"
                + "id_project) VALUES(?,?,?,?,?,?,?,?)";
        try{
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);                    
            preparedStatement.setString(1, task.getName());
            preparedStatement.setString(2, task.getDescription());
            preparedStatement.setBoolean(3, task.isCompleted());
            preparedStatement.setString(4, task.getNotes());
            preparedStatement.setDate(5, new Date(task.getDeadline().getTime()));
            preparedStatement.setDate(6, new Date(task.getCreate_date().getTime()));
            preparedStatement.setDate(7, new Date(task.getUpdate_date().getTime()));
            preparedStatement.setInt(8, task.getId_project());
            preparedStatement.execute();
            
            
        }catch(Exception e){
            throw new RuntimeException("Erro ao salvar no banco de dados"
                    + e.getMessage(), e);            
        }finally{
            ConnectionFactory.closeConnection(connection, preparedStatement);
        }
        
       
    }
    
    public void update(Task task){
        String sql = "UPDATE task SET"
                + "name = ?,"
                + "description = ?,"
                + "completed = ?,"
                + "notes = ?,"
                + "deadline = ?,"
                + "created_date = ?,"
                + "update_date = ?,"
                + "id_project = ?,"
                + "WHERE id = ?";
        try{
            //Estabelecendo conexão com o banco
            connection = ConnectionFactory.getConnection();
            
            //Preparando sql a ser executada
            preparedStatement = connection.prepareStatement(sql);
            
            //Setando valores para preenchimento da query
            preparedStatement.setString(1, task.getName());
            preparedStatement.setString(2, task.getDescription());
            preparedStatement.setBoolean(3, task.isCompleted());
            preparedStatement.setString(4, task.getNotes());
            preparedStatement.setDate(5, new Date(task.getDeadline().getTime()));
            preparedStatement.setDate(6, new Date(task.getCreate_date().getTime()));
            preparedStatement.setDate(7, new Date(task.getUpdate_date().getTime()));
            preparedStatement.setInt(8, task.getId_project());
            preparedStatement.setInt(9, task.getId());
            
            //Executando a query
            preparedStatement.execute();
                      
        }catch(Exception e){
            throw new RuntimeException("Erro ao atualizar os dados "+e.getMessage());
            
        }finally{
            ConnectionFactory.closeConnection(connection, preparedStatement);
        }
        
        
        
        
    }
    
    public void deleteById(int taskId) throws SQLException{
        String sql = "DELETE FROM tasks WHERE id = ?";
        
        try {
            //Estabelecendo conexão com o banco
            connection = ConnectionFactory.getConnection();
            
            //Preparando sql a ser executada
            preparedStatement = connection.prepareStatement(sql);
            
            //Setando valores para preenchimento da query
            preparedStatement.setInt(1, taskId);
            
            //Executando a query
            preparedStatement.execute();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar a tarefa", e);
        } finally{
            ConnectionFactory.closeConnection(connection, preparedStatement);
        }
    }
    
    public List<Task> getAllByProjectId(int id_project){
        String sql = "SELECT * FROM tasks WHERE id_project =? ";
         List<Task> tasks = new ArrayList<>();
        try{
            
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            
            //Setando valor do filtro
            preparedStatement.setInt(1, id_project);
            
            //Valor retornado pela execução da query
            resultSet = preparedStatement.executeQuery();
            
            //Enquanto houver valores
            while(resultSet.next()){
                
                Task task = new Task();
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setCompleted(resultSet.getBoolean("completed"));
                task.setNotes(resultSet.getString("notes"));
                task.setDeadline(resultSet.getDate("deadline"));
                task.setCreate_date(resultSet.getDate("created_date"));
                task.setUpdate_date(resultSet.getDate("update_date"));
                task.setId_project(resultSet.getInt("id_project"));
                               
                tasks.add(task);
                
                
                
            }
            
            
        }catch(Exception e){
            throw new RuntimeException("Erro ao Listar as tarefas", e);
        }finally{
            ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
        }
        
        
        return tasks;
        
    }
    
    
}
