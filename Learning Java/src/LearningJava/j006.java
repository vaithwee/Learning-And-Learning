package LearningJava;

/**
 * Created by Vaith on 16/8/1.
 */

class Employee1
{
    public String name;
    private double salary;
    public Employee1(String empName)
    {
        name = empName;
    }

    public void setSalary(double salary)
    {
        this.salary = salary;
    }

    public void printEmp()
    {
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }
}
public class j006 {
    public static void main(String []args)
    {
        Employee1 emp = new Employee1("Ransika");
        emp.setSalary(1000);
        emp.printEmp();
    }
}
