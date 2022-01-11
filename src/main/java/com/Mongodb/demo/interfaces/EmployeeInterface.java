/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Mongodb.demo.interfaces;

import com.Mongodb.demo.Model.Employee;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Rohit Yadav
 */
public interface EmployeeInterface extends MongoRepository<Employee, String> {

//    List<Employee> findByTitleContaining(String Name);

}
