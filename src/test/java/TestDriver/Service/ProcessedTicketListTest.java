package TestDriver.Service;

import driver.service.ProcessedTicketList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProcessedTicketListTest {

    @Test
    public void processTicketList(){
        ProcessedTicketList processedTicketList = new ProcessedTicketList();
        String response = processedTicketList.listTickets(20,2);
        assertEquals("SUCCESS", response);
    }
}
