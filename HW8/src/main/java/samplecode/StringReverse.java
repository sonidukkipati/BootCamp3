package samplecode;

/**
 * Created by sc on 4/10/2017.
 */
public class StringReverse {

    StringReverse(){
        System.out.println("Hi");
    }
 public static void main(String[] args){
        String[] n= new String[6];
        n [0] ="H";
        n[1] = "E";
        n[2] = "L";
        n[3] = "L";
        n[4] = "O";
        n[5] = "W";


        StringReverse stringReverse = new StringReverse();
         String str=stringReverse.reverse(n);
         System.out.println(str);



 }


    public String reverse(String [] k) {

        System.out.println(k.length);
        String s = "";
        for (int i = k.length-1; i>-1; i--) {


            //System.out.println(k[i]);
            s= s + k[i];


        }return s;


    }




}
