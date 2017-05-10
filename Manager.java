package Level3Homework6;

/**
 * Created by sc on 5/8/2017.
 */
public class Manager extends Employee {
private double bonus;
    public Manager(){
        System.out.println("He is the Manager");
    }
    @Override
    public double paySalary(double emp_salary){
        double bonus = 100.00;
        emp_salary = emp_salary + bonus;
        System.out.println("This is the salary of the Employee" + emp_salary) ;
        return emp_salary;
    }
}
