package class01;

import org.testng.annotations.Test;

public class priority {

    @Test(priority = 3)
    public void ATest() {
        System.out.println("I am A test");
    }
    @Test(priority = 1)
    public void BTest() {
        System.out.println("I am B test");
    }
    @Test(priority = 2)
    public void CTest() {
        System.out.println("I am C test");
    }
//   by default priority is 0

    @Test
    public void DTest() {
        System.out.println("I am D test");
    }
    @Test
    public void ABTest() {
        System.out.println("I am AB test");
    }

}
