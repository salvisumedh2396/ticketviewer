package driver.controller;

import driver.auth.Auth;
import driver.mapper.TicketMapper;
import driver.model.Ticket;
import driver.service.ProcessedTicketList;

public class TicketController {

    public static final String ENDPOINT = "/api/v2/tickets/";

    public String showTicket(int id)
    {
        if(id<=0)
            return "ERROR: ID must be > 0";

        System.out.println("\nProcessing your request, please wait...");
        Auth httpRequest = new Auth();
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

    public String displayTicketList(int perPageLimit, int pageNo, ProcessedTicketList processedTicketList){
        String response = processedTicketList.listTickets(perPageLimit, pageNo);
        processedTicketList.displayTicketsList();
        processedTicketList.displayPageNo(pageNo);
        return response;
    }

    /*private void displayInformation(Ticket ticket) {
        System.out.println(ticket.toString());
    }*/

}
