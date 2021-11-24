package TestDriver.Auth;

import driver.auth.Auth;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AuthTest {

    @Test
    public void viewSingleTicket(){
        Auth singleTicketRequest = new Auth();
        singleTicketRequest.requestResponse("/api/v2/tickets/40.json",null);
        assertEquals(200, Auth.responseCode);
    }

    @Test
    public void viewTicketList(){
        Auth ticketListRequest = new Auth();
        ticketListRequest.requestResponse("/api/v2/tickets.json","?page=3&per_page=20");
        assertEquals(200,Auth.responseCode);
    }

    @Test
    public void sendAnInvalidRequest(){
        Auth invalidRequest = new Auth();
        String response = invalidRequest.requestResponse("/api/v2/tickets/1111.json",null);
        assertEquals("Not Found - very few people reach this page..!!",response);
    }

}
