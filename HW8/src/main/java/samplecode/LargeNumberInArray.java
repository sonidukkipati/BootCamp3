package samplecode;

/**
 * Created by sc on 4/10/2017.
 */
public class LargeNumberInArray {

    LargeNumberInArray(){

        System.out.println("This is the Constructor");
    }

    public static void main(String[] args){

        int[] k = new int[6];
        k[0]=3;
        k[1]=5;
        k[2] = 27;
        k[3]=37;
        k[4] = 19;
        k[5]=2;


        LargeNumberInArray largeNumberInArray = new LargeNumberInArray();
        int number=largeNumberInArray.findLargeNumber(k);
        System.out.println(number);

    }


    public int findLargeNumber(int[]n){
        int large = n[0];
        for(int i=1;i<n.length;i++){

            if(n[i]>large){

                large = n[i];

                //System.out.println(n[i]);
            }
        }return large;

    }


}
