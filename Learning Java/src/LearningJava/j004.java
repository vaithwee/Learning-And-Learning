package LearningJava;

/**
 * Created by Vaith on 16/8/1.
 */

class Employee
{
    String name;
    int age;
    String designation;
    double salary;

    public Employee(String name)
    {
        this.name = name;
    }

    public void empAge(int age)
    {
        this.age = age;
    }

    public void empDesignation(String designation)
    {
        this.designation = designation;
    }

    public void  empSalary(double salary)
    {
        this.salary = salary;
    }

    public void  printEmployee()
    {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Designation: " + designation);
        System.out.println("Salary: " + salary);
        System.out.println();
    }
}

public class j004 {
    public static void main(String []args)
    {
        Employee empOne = new Employee("James Smith");
        Employee empTwo = new Employee("Mary Anne");

        empOne.empAge(26);
        empOne.empDesignation("Senior Software Engineer");
        empOne.empSalary(1000);
        empOne.printEmployee();

        empTwo.empAge(21);
        empTwo.empDesignation("Software Engineer");
        empTwo.empSalary(500);
        empTwo.printEmployee();
    }
}
