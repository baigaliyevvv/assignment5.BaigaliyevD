package controllers;

import entities.Employee;
import repositories.interfaces.IEmployeeRepository;

import java.util.List;

public class EmployeeController {
    private final IEmployeeRepository repo;
    public EmployeeController(IEmployeeRepository repo){
        this.repo = repo;
    }
    public String getEmployeeName(String name){
        Employee employee = repo.getEmployeeName(name);
        return (employee == null ? "Employee was not found" : employee.toString());
    }
    public String dropEmployeeById(int id){
        boolean dropped = repo.dropEmployeeById(id);
        return (dropped ? "Employee was deleted." : "Employee was not found...");
    }
    public String addEmployee(String name, String surname, String specialization, int age, int salary, String email){
        Employee employee = new Employee(name, surname, specialization, age, salary, email);
        boolean added = repo.addEmployee(employee);
        return (added ? "Employee was added" : "Something went wrong...");
    }
    public String getEmployeeID(int id){
        Employee employee = repo.getEmployeeID(id);
        return (employee == null ? "Employee was not found" : employee.toString());
    }
    public String getAllEmployees(){
        List<Employee> employees = repo.getAllEmployees();
        return employees.toString();
    }
    public String getEmployeeBySalary(int salary){
        List<Employee> employees = repo.getEmployeeBySalary(salary);
        return employees.toString();
    }
}
