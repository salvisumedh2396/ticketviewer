package TestDriver;

import TestDriver.Auth.AuthTest;
import TestDriver.Controller.TicketControllerTest;
import TestDriver.Mapper.TicketMapperTest;
import TestDriver.Service.ProcessedTicketListTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        AuthTest.class,
        TicketControllerTest.class,
        TicketMapperTest.class,
        ProcessedTicketListTest.class
})

public class TestSuite {

}
