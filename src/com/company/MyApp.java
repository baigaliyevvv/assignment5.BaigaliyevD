package com.company;

import controllers.EmployeeController;
import repositories.interfaces.IEmployeeRepository;

import java.util.Scanner;

public class MyApp {
    private final EmployeeController controller;
    private final Scanner sc;

    public MyApp(IEmployeeRepository employeeRepository){
        controller = new EmployeeController(employeeRepository);
        sc = new Scanner(System.in);
    }
    public void run(){
        while(true){
            System.out.println();
            System.out.println("Welcome to the Application!");
            System.out.println("Choose option :");
            System.out.println("1. Search employee by name");
            System.out.println("2. Remove employee by id");
            System.out.println("3. Add employee to Database");
            System.out.println("4. Search employee by id");
            System.out.println("5. List all employees");
            System.out.println("6. Find employee by salary");
            System.out.println("0. Exit");
            System.out.println();
            try{
                System.out.print("Enter number (0-6) : ");
                int answer = sc.nextInt();
                sc.nextLine();
                if(answer == 1){
                    getEmployeeByNameMenu();
                }else if(answer == 2){
                    dropEmployeeByIdMenu();
                }
                else if(answer == 3){
                    addEmployeeMenu();
                }
                else if(answer == 4){
                    getEmployeeByIdMenu();
                }
                else if(answer == 5){
                    getAllEmployeesMenu();
                }
                else if(answer == 6){
                    getEmployeeBySalaryMenu();
                }else{
                    break;
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    public void getEmployeeByNameMenu(){
        System.out.print("Enter the name : ");
        String name = sc.nextLine();

        String answer = controller.getEmployeeName(name);
        System.out.println(answer);
    }
    public void dropEmployeeByIdMenu(){
        System.out.print("Enter the id : ");
        int id = sc.nextInt();
        sc.nextLine();

        String answer = controller.dropEmployeeById(id);
        System.out.println(answer);
    }
    public void addEmployeeMenu(){
        System.out.print("Enter the employee name : ");
        String name = sc.nextLine();
        System.out.print("Enter the employee surname : ");
        String surname = sc.nextLine();
        System.out.print("Enter the employee specialization : ");
        String specialization = sc.nextLine();
        System.out.print("Enter the employee age : ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter the employee salary : ");
        int salary = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter the employee email : ");
        String email = sc.nextLine();

        String response = controller.addEmployee(name, surname, specialization, age, salary, email);
        System.out.println(response);
    }
    public void getEmployeeByIdMenu(){
        System.out.print("Enter the id : ");
        int id = sc.nextInt();
        sc.nextLine();

        String answer = controller.getEmployeeID(id);
        System.out.println(answer);
    }
    public void getAllEmployeesMenu(){
        String answer = controller.getAllEmployees();
        System.out.println(answer);
    }
    public void getEmployeeBySalaryMenu(){
        System.out.print("Enter the salary : ");
        int salary = sc.nextInt();
        sc.nextLine();

        String answer = controller.getEmployeeBySalary(salary);
        System.out.println(answer);
    }
}
