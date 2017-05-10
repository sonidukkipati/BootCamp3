package Level3HomeWork5;

/**
 * Created by sc on 5/8/2017.
 */
public class Part2 extends TestBase{

    public Part2(){
        System.out.println("This is Part2 HomeWork in Homework5");
    }

    public static void main(String args[]) throws InterruptedException {
      TestBase  log_in = new Part2();
      log_in.TestBaseLogin();

      TestBase log_out = new Part2();
      log_out.TestBaseLogout();


    }

}
