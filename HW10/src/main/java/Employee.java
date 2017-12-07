import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by sc on 6/11/2017.
 */
public class Employee {
  private String name;
  private String ID;

    public Employee(String name,String ID) {
        System.out.println("This is constructor for Employee");
        this.name = name;
        this.ID = ID;
      System.out.println(name.toString());
      System.out.println(ID.toString());
    }
    public String getname(){
        return this.name;
    }
    public String getid(){
        return this.ID;
    }

    public static void main(String[] args) {
        ArrayList<Employee> e;
        e = new ArrayList<Employee>();
        e.add(new Employee("A","123"));
        e.add(new Employee("B","123"));
        e.add(new Employee("C","435"));
        e.add(new Employee("E","789"));
        e.add(new Employee("H","678"));
        e.add(new Employee("K","890"));
        System.out.println(e);
        Employee e1 = e.get(1);

        for (int i=0;i<e.size();i++){

            System.out.println(e.get(i).getname());


        }

        Iterator<Employee> it = e.iterator();
        while(it.hasNext()){

            System.out.println(it.next().getid());
        }
    }

}