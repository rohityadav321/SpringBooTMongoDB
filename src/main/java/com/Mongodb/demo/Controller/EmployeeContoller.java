/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Mongodb.demo.Controller;

import com.Mongodb.demo.Model.Employee;
import com.Mongodb.demo.Model.Success;
import com.Mongodb.demo.interfaces.EmployeeInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Rohit Yadav
 */
//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class EmployeeContoller {

    @Autowired
    private EmployeeInterface empIn;

    @PostMapping(value = "/addemployee", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Employee> addemp(@RequestBody Employee emp) {
        try {
            Employee employee = empIn.save(new Employee(emp.getId(), emp.getName(), emp.getEmail(), emp.getDept(), emp.getPost(), emp.getContact()));
            return new ResponseEntity<>(employee, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/edit/{ID}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Employee> editemp(@PathVariable String ID, @RequestBody Employee emp) {

        Optional<Employee> employees = empIn.findById(ID);
        if (employees.isPresent()) {
            Employee _emp = employees.get();
            _emp.setEmail(emp.getEmail());
            _emp.setContact(emp.getContact());
            Employee employee = empIn.save(_emp);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping(value = "/delete/{ID}")
    public ResponseEntity<?> delete(@PathVariable String ID) {
        Optional<Employee> emps = empIn.findById(ID);
        if (emps.isPresent()) {
            empIn.deleteById(ID);
            return new ResponseEntity<>("Ok",HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/getemp/{ID}", produces = "application/json")
    public ResponseEntity<Employee> Get(@PathVariable String ID) {
        Optional<Employee> emps = empIn.findById(ID);
        if (emps.isPresent()) {
            return new ResponseEntity<>(emps.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/getall", produces = "application/json")
    public ResponseEntity<List<Employee>> Getall() {
        try {
            List<Employee> Emp = new ArrayList<>();

            empIn.findAll().forEach(Emp::add);

            if (Emp.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(Emp, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
