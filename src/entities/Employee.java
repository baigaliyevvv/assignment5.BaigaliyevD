package entities;

public class Employee {
    private int id;
    private String name;
    private String surname;
    private String specialization;
    private int age;
    private int salary;
    private String email;

    public Employee(){

    }
    public Employee(String name, String surname, String specialization, int age, int salary, String email){
        setName(name);
        setSurname(surname);
        setSpecialization(specialization);
        setAge(age);
        setSalary(salary);
        setEmail(email);
    }
    public Employee(int id,String name, String surname, String specialization, int age, int salary, String email){
        setId(id);
        setName(name);
        setSurname(surname);
        setSpecialization(specialization);
        setAge(age);
        setSalary(salary);
        setEmail(email);
    }

    @Override
    public String toString() {
        return "\nEmployee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", specialization='" + specialization + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", email='" + email + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
