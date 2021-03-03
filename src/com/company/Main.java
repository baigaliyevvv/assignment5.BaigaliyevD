package com.company;

import data.DataBase;
import data.interfaces.IDataBase;
import repositories.EmployeeRepository;
import repositories.interfaces.IEmployeeRepository;

public class Main {

    public static void main(String[] args) {
        IDataBase db = new DataBase();
        IEmployeeRepository repo = new EmployeeRepository(db);
        MyApp app = new MyApp(repo);
        app.run();
    }
}
