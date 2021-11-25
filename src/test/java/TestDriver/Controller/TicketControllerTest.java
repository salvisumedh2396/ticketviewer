package TestDriver.Controller;

import driver.controller.TicketController;
import driver.service.ProcessedTicketList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TicketControllerTest {

    /**
     * Check for a successful retrieval of single ticket
     */
    @Test
    public void recordSingleTicketResponse(){
        TicketController singleTicket = new TicketController();
        String response = singleTicket.showTicket(2);
        assertEquals("SUCCESS", response);
    }

    /**
     * Checks for a successful retrieval of ticket list
     */
    @Test
    public void recordMultipleTicketResponse(){
        TicketController multipleTickets = new TicketController();
        ProcessedTicketList processedTicketList = new ProcessedTicketList();
        String response = multipleTickets.displayTicketList(20,2, processedTicketList);
        assertEquals("SUCCESS", response);
    }

}
