package class01;

import org.testng.annotations.Test;

public class enableDisable {
    @Test(enabled = false)
    public void ATest() {
        System.out.println("I am A test");
    }

    @Test
    public void BTest() {
        System.out.println("I am B test");
    }

    @Test(enabled = false)
    public void CTest() {
        System.out.println("I am C test");
    }

}
