package class01;

import org.testng.annotations.Test;

public class dependOn {

    @Test
    public void Login() {
        System.out.println(7/0);
    }

    @Test(dependsOnMethods = {"Login"})
    public void DashBoardVerification() {
        System.out.println(" After login I am verifying the dashboard");
    }
}
