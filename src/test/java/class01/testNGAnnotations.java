package class01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testNGAnnotations {

//    first test case
     @Test
    public void AfirstTestCase() {
         System.out.println("I am the first test case");
     }
   @Test
     public void BsecondTestCase() {
         System.out.println("I am the second test case");
     }

     @Test
    public void thirdTestCase() {
         System.out.println("I am third test case");
     }

     @Test
    public void fourthTestCase() {
        System.out.println("I am fourth test case");
    }

    @BeforeMethod
    public void beforeMethod() {
         System.out.println("I am a before method");
     }

     @AfterMethod
    public void afterMethod() {
         System.out.println("I am after method");
     }

}

