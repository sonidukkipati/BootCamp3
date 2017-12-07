package samplecode;

/**
 * Created by sc on 4/10/2017.
 */
public class AddOddNumbers {

    AddOddNumbers(){

        System.out.println("Init");
    }
    public static void main(String[] args) {

        int[] k = new int [6];
        k[0]=3;
        k[1]=5;
        k[2] = 7;
        k[3]=17;
        k[4] = 19;
        k[5]=2;
        AddOddNumbers addOddNumbers = new AddOddNumbers();
        int count = addOddNumbers.OddSum(k);

        System.out.println("The Count is" +count);

    }

    public int OddSum(int[] n) {

        int sum = 0;
        for (int i = 0; i < n.length; i++) {

            if (n[i] % 2 == 1) {

                sum = sum + n[i];
                System.out.println("The odd number is" + n[i]);
            }

        }
        return sum;

    }
}
