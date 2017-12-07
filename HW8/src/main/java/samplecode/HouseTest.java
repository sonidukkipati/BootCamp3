package samplecode;

//import org.apache.log4j.Logger;

/**
 * Created by sc on 4/7/2017.
 */
public class HouseTest {
    public static House house;
    public  static TraditionalHouse th;
    public  static ModernHouse mh;
    //static final Logger logger = Logger.getLogger(HouseTest.class);

    public static void main(String[] args){

        house = new House();
        th = new TraditionalHouse();
        TraditionalHouse.Login();
        mh = new ModernHouse();
        mh.house_color = "Brown";
       ConservativeHouse ch = new ConservativeHouse();
        house.construction();
        th.construction();
        mh.construction();
        ch.construction();
        System.out.println(house.house_color);
        System.out.println(th.house_color);
        System.out.println(mh.house_color);



    }
}
