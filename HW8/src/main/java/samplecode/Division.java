package samplecode;

/**
 * Created by sc on 4/6/2017.
 */
public class Division {
    public static void main(String args[]) {

        Division division = new Division();
       int k= division.divide(5,2);
       System.out.println(k);



    }
    Division() {
        System.out.println("This is division class");
    }
   public int divide(int i,int j) {
       int k = i / j;
       return k;

   }


}
