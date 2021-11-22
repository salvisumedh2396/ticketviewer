package driver.service;

import driver.auth.Auth;
import driver.mapper.TicketMapper;
import driver.model.Ticket;

public class ProcessedTicketList {

    public boolean isPrevious = false;
    public boolean isNext = false;
    public Ticket[] tickets;

    private static String ENDPOINT = "/api/v2/tickets.json";

    public String listTickets(int perPageLimit, int pageNo){

        if(pageNo < 1){
            return "Page number must be greater than zero";
        }else if(perPageLimit < 1){
            return "There must be atleast 1 record per page";
        }

        Auth httpRequest = new Auth();
        String parameters = "?page=" + pageNo + "&per_page=" + perPageLimit;
        String jsonResponse = httpRequest.requestResponse(ENDPOINT, parameters);

        if(Auth.responseCode > 199 && Auth.responseCode < 400){
            TicketMapper ticketMapper = new TicketMapper();
            ProcessedTicketList processedTicketList = ticketMapper.parseAllTickets(jsonResponse);

            if(processedTicketList == null){
                return "Could not find any tickets associated with this account";
            }

            this.tickets = processedTicketList.tickets;
            this.isNext = processedTicketList.isNext;
            this.isPrevious = processedTicketList.isPrevious;

            for(int i=0; i<tickets.length; i++)
                System.out.println(tickets[i]);

            return "SUCCESS";
        }

        //display the results

        return Auth.displayErrorMessage(Auth.responseCode) ;

    }

}
