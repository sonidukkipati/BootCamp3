package Level3Homework6;

/**
 * Created by sc on 5/8/2017.
 */
public class Employee {

    protected double salary;


    public static void main(String args[]){

        Employee emp1 = new Employee();
        emp1.paySalary(125.50);
        Manager manager1 = new Manager();
        manager1.paySalary(234.25);
        Contractor contractor1 = new Contractor();
        contractor1.paySalary(245.00);
        Employee emp2 = new Manager();
        emp2.paySalary(897.88);

    }
    public Employee(){
        System.out.println("He is the employee");
    }

    public double paySalary(double emp_salary){
       System.out.println("This is the salary of the Employee" + emp_salary) ;
       return emp_salary;
    }
}
