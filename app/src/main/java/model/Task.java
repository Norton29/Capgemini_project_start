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
public class Task {
    
    private int id;
    private String name;
    private String description;
    private String notes;
    private boolean status;
    private Date deadline;
    private Date create_date;
    private Date update_date;
    private int id_project;

    public Task() {
    }

    public Task(int id, String name, String description, String notes, boolean status, Date deadline, Date create_date, Date update_date, int id_project) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.notes = notes;
        this.status = status;
        this.deadline = deadline;
        this.create_date = create_date;
        this.update_date = update_date;
        this.id_project = id_project;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
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

    public int getId_project() {
        return id_project;
    }

    public void setId_project(int id_project) {
        this.id_project = id_project;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", name=" + name + ", description=" + description + ", notes=" + notes + ", status=" + status + ", deadline=" + deadline + ", create_date=" + create_date + ", update_date=" + update_date + ", id_project=" + id_project + '}';
    }
    
    

    
}
