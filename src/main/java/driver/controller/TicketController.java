package driver.controller;

import driver.auth.Auth;
import driver.mapper.TicketMapper;
import driver.model.Ticket;
import driver.service.ProcessedTicketList;

public class TicketController {

    public static final String ENDPOINT = "/api/v2/tickets/";

    /**
     * Displays the details of a single ticket based on the provided ticketid
     * @param id - id of the ticket for which the user wants to display details
     * @return response indicating whether the process was a success or failure. On failure prints an error.
     */
    public String showTicket(int id)
    {
        if(id<=0)
            return "ERROR: ID must be > 0";

        System.out.println("Did you know..?? \nZendesk was set up in 2007 by 3 friends in Copenhagen, Denmark");
        System.out.println("\nProcessing your request, please wait...");
        Auth httpRequest = new Auth();
        httpRequest.getCredentials();
        String url = ENDPOINT + id + ".json";
        String response = httpRequest.requestResponse(url, null);
        //Request success - 200 or 300 range
        if(Auth.responseCode> 199 && Auth.responseCode < 400)
        {
            //Parse json response and display ticket
            TicketMapper jsonParser = new TicketMapper();
            Ticket ticket = jsonParser.parseOneTicket(response);
            if(ticket == null)
                return "Provided ticket could not be parsed";
            ProcessedTicketList processedTicketList = new ProcessedTicketList();
            processedTicketList.displayHeader();
            processedTicketList.displayTickets(ticket);

            return "SUCCESS";
        }

        return httpRequest.displayErrorMessage(Auth.responseCode);
    }


    /**
     * Used to display a list of tickets
     * @param perPageLimit - provides the count of how many tickets are to be displayed per page
     * @param pageNo - the page number of the current page
     * @param processedTicketList - contains details of whether there are more pages that could be displayed, status etc.
     * @return return a success response or display error message.
     */
    public String displayTicketList(int perPageLimit, int pageNo, ProcessedTicketList processedTicketList){
        String response = processedTicketList.listTickets(perPageLimit, pageNo);
        processedTicketList.displayTicketsList();
        processedTicketList.displayPageNo(pageNo);
        return response;
    }

}
