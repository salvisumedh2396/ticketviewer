package TestDriver;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

    public static void main(String[] args){
        Result result = JUnitCore.runClasses(TestSuite.class);

        for(Failure failure: result.getFailures()){
            System.out.println("\n" + failure.toString());
        }

        if(result.wasSuccessful()){
            System.out.println("\n Yayy..!! All tests have passed");
        }else{
            System.out.println("\n Some tests might have failed");
        }
    }
}
