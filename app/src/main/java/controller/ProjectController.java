/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import util.ConnectionFactory;

/**
 *
 * @author norton
 */
public class ProjectController {
    
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    
    public void insertProject(Project project){
        String sql = "INSERT INTO projects (name,"
                + "description,"
                + "create_date,"
                + "update_date) "
                + "VALUES(?,?,?,?)";
        
        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, project.getName());
            preparedStatement.setString(2, project.getDescription());
            preparedStatement.setDate(3, new Date(project.getCreate_date().getTime()));
            preparedStatement.setDate(4, new Date(project.getUpdate_date().getTime()));
            
            preparedStatement.execute(); 
                    
            
        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir novo projeto", e);
            
        } finally{
            ConnectionFactory.closeConnection(connection, preparedStatement);
        }
        
        
    }
    
    
    public void update(Project project){
        String sql = "UPDATE projects SET "
                + "name = ?,"
                + "description = ?,"
                + "create_date = ?,"
                + "update_date = ?,"
                + "WHERE id = ?";
        
        
        try{
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, project.getName());
            preparedStatement.setString(2, project.getDescription());            
            preparedStatement.setDate(3, new Date(project.getCreate_date().getTime()));
            preparedStatement.setDate(4, new Date(project.getUpdate_date().getTime()));
            preparedStatement.setInt(5, project.getId());
            
            preparedStatement.execute();
              
            
        }catch(Exception e ){
            throw new RuntimeException("Erro ao atualizar projeto", e);
        }finally{
            ConnectionFactory.closeConnection(connection, preparedStatement);
                    
        }
    }
    
    public void delete(int id){
        String sql = "DELETE FROM project WHERE id = ?";
        
        try{ 
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            
            boolean execute = preparedStatement.execute();
                    if(execute = true){
                        System.out.println("Dados Excluídos com sucesso!");
                    }
                    
            
        }catch(Exception e){
            throw new RuntimeException("Erro ao deletar projeto", e);
        }finally{
            ConnectionFactory.closeConnection(connection, preparedStatement);
        }
    }
    
    public List<Project> getAllProjects(){
        String sql = "SELECT * FROM projects";
        List<Project> projects = new ArrayList<>();
        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery(sql);
            
            while(resultSet.next()){
                
                Project project = new Project();
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));                
                project.setCreate_date(resultSet.getDate("create_date"));
                project.setUpdate_date(resultSet.getDate("update_date"));
                
                               
                projects.add(project);
            }            
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar projetos", e);
        }finally{
            ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
        }
        return projects;        
    }
    
    public List<Project> getAllProjectsById(int id){
        String sql = "SELECT * FROM projects WHERE id = ?";
        List<Project> projects = new ArrayList<>();
        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery(sql);
            
             while(resultSet.next()){
                
                Project project = new Project();
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));                
                project.setCreate_date(resultSet.getDate("create_date"));
                project.setUpdate_date(resultSet.getDate("update_date"));
                
                               
                projects.add(project);
             }
            
        } catch (Exception e) {
                throw new RuntimeException("Erro ao buscar projetos", e);
          }finally{
            ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
        }
        return projects;        
    }
    
    
    
    
}
