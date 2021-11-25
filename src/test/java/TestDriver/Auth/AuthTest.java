package TestDriver.Auth;

import driver.auth.Auth;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class AuthTest {

    /**
     * Checks if a successful call is made for the details of a single ticket
     */
    @Test
    public void viewSingleTicket(){
        Auth singleTicketRequest = new Auth();
        singleTicketRequest.requestResponse("/api/v2/tickets/40.json",null);
        assertEquals(200, Auth.responseCode);
    }

    /**
     * Checks if a successful call is made for trhe retrieval of ticket list
     */
    @Test
    public void viewTicketList(){
        Auth ticketListRequest = new Auth();
        ticketListRequest.requestResponse("/api/v2/tickets.json","?page=3&per_page=20");
        assertEquals(200,Auth.responseCode);
    }

    /**
     * Checks if the code provides an appropriate response when a request made is invalid
     */
    @Test
    public void sendAnInvalidRequest(){
        Auth invalidRequest = new Auth();
        String response = invalidRequest.requestResponse("/api/v2/tickets/1111.json",null);
        assertEquals("Not Found - very few people reach this page..!!",response);
    }

    /**
     * Check if creadentials are retrieved successfully
     * @throws IOException
     */
    @Test
    public void getCredentials() throws IOException {
        Auth auth = new Auth();
        auth.getCredentials();
    }

}
