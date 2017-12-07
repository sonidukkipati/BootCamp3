import org.testng.annotations.Test;

/**
 * Created by sc on 6/9/2017.
 */
public class teparary {

    @Test(groups ={"UI"})
    public void Test1(){
        System.out.println("TestA");
    }
    @Test(groups ={"Functional","GUI","Smoke"})
    public void Test3(){
        System.out.println("TestB");
    }
    @Test(enabled=true)
    public void Test2(){
        System.out.println("TestC");
    }
    @Test(enabled = true,priority=2)
    public void Test4(){
        System.out.println("TestD");
    }

    @Test(enabled = true,priority=2,description="This test is an example test",timeOut=1000)
    public void Test5(){
        System.out.println("TestE");
    }


}
