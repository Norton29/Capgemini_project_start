/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author norton
 */
public class Project {
    
    private int id;
    private String name;
    private String description;
    private Date create_date;
    private Date update_date;

    public Project() {
    }

    public Project(int id, String name, String description, Date create_date, Date update_date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.create_date = create_date;
        this.update_date = update_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    @Override
    public String toString() {
        return "Project{" + "id=" + id + ", name=" + name + ", description=" + description + ", create_date=" + create_date + ", update_date=" + update_date + '}';
    }
    
    
    
    
}
