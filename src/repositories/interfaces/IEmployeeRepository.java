package repositories.interfaces;

import entities.Employee;

import java.util.List;

public interface IEmployeeRepository {
    Employee getEmployeeName(String name);
    boolean dropEmployeeById(int id);
    boolean addEmployee(Employee employee);
    Employee getEmployeeID(int id);
    List<Employee> getAllEmployees();
    List<Employee> getEmployeeBySalary(int salary);
}
