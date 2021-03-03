package repositories;

import data.interfaces.IDataBase;
import entities.Employee;
import repositories.interfaces.IEmployeeRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    public final IDataBase db;

    public EmployeeRepository(IDataBase db) {
        this.db = db;
    }

    public Employee getEmployeeName(String name) {
        Connection con = null;
        try{
            con = db.getConnection();
            String query = "select * from employee where name = ?";
            PreparedStatement st = con.prepareStatement(query);

            st.setString(1, name);

            ResultSet rs = st.executeQuery();
            if(rs.next()){
                Employee employee = new Employee(rs.getInt("id"),
                        rs.getString("name"), rs.getString("surname"),
                        rs.getString("specialization"), rs.getInt("age"),
                        rs.getInt("salary"),rs.getString("email")
                );
                return employee;
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }finally {
            try {
                con.close();
            }catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
        return null;
    }
    public boolean dropEmployeeById(int id) {
        Connection con = null;
        try{
            con = db.getConnection();
            String query = "delete from employee where id = ?";
            PreparedStatement st = con.prepareStatement(query);

            st.setInt(1, id);
            boolean execution = st.execute();
            return true;
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }finally {
            try {
                con.close();
            }catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
        return false;
    }
    public boolean addEmployee(Employee employee) {
        Connection con = null;
        try{
            con = db.getConnection();
            String query = "insert into employee (name, surname, specialization, age, salary, email) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(query);

            st.setString(1, employee.getName());
            st.setString(2, employee.getSurname());
            st.setString(3, employee.getSpecialization());
            st.setInt(4, employee.getAge());
            st.setInt(5,employee.getSalary());
            st.setString(6, employee.getEmail());
            boolean execution = st.execute();
            return true;
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
        return false;
    }
    public Employee getEmployeeID(int id) {
        Connection con = null;
        try{
            con = db.getConnection();
            String query = "select * from employee where id = ?";
            PreparedStatement st = con.prepareStatement(query);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if(rs.next()){
                Employee employee = new Employee(rs.getInt("id"),
                        rs.getString("name"), rs.getString("surname"),
                        rs.getString("specialization"), rs.getInt("age"),
                        rs.getInt("salary"),rs.getString("email")
                );
                return employee;
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }finally {
            try {
                con.close();
            }catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
        return null;
    }
    public List<Employee> getAllEmployees() {
        Connection con = null;
        try {
            con = db.getConnection();
            String query = "select * from employee";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);
            List<Employee> employees = new LinkedList<>();
            while (rs.next()){
                Employee employee = new Employee(rs.getInt("id"),
                        rs.getString("name"), rs.getString("surname"),
                        rs.getString("specialization"), rs.getInt("age"),
                        rs.getInt("salary"),rs.getString("email"));
                employees.add(employee);
            }
            return employees;
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }finally {
            try {
                con.close();
            }catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
        return null;
    }
    public List<Employee> getEmployeeBySalary(int salary) {
        Connection con = null;
        try{
            con = db.getConnection();
            String query = "select * from employee where salary = ?";
            PreparedStatement st = con.prepareStatement(query);

            st.setInt(1, salary);
            List<Employee> employees = new LinkedList<>();
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                Employee employee = new Employee(rs.getInt("id"),
                        rs.getString("name"), rs.getString("surname"),
                        rs.getString("specialization"), rs.getInt("age"),
                        rs.getInt("salary"),rs.getString("email"));
                employees.add(employee);
            }
            return employees;
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }finally {
            try {
                con.close();
            }catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
