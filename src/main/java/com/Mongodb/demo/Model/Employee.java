/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Mongodb.demo.Model;

import java.util.logging.Logger;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Rohit Yadav
 */
@Document(collection = "Employees")
public class Employee {

    @Id
    private String id;
    private String Name;
    private String Email;
    private String Dept;
    private String Post;
    private double Contact;

    public Employee(String id, String Name, String Email, String Dept, String Post, double Contact) {
        this.id = id;
        this.Name = Name;
        this.Email = Email;
        this.Dept = Dept;
        this.Post = Post;
        this.Contact = Contact;
    }
    private static final Logger LOG = Logger.getLogger(Employee.class.getName());

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDept() {
        return Dept;
    }

    public void setDept(String Dept) {
        this.Dept = Dept;
    }

    public String getPost() {
        return Post;
    }

    public void setPost(String Post) {
        this.Post = Post;
    }

    public double getContact() {
        return Contact;
    }

    public void setContact(double Contact) {
        this.Contact = Contact;
    }

}
