package driver.service;

import driver.auth.Auth;
import driver.mapper.TicketMapper;
import driver.model.Ticket;

public class ProcessedTicketList {

    public boolean isPrevious = false;
    public boolean isNext = false;
    public Ticket[] tickets;

    private static String ENDPOINT = "/api/v2/tickets.json";

    /**
     * Display the tickets
     * @param perPageLimit number of ticket details that are to be diaplayed per request
     * @param pageNo - count of page number.
     * @return reponse that indicates success or prints error.
     */
    public String listTickets(int perPageLimit, int pageNo){

        if(pageNo < 1){
            return "Page number must be greater than zero";
        }else if(perPageLimit < 1){
            return "There must be atleast 1 record per page";
        }

        Auth httpRequest = new Auth();
        httpRequest.getCredentials();
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

            return "SUCCESS";
        }

        //display the results
        return Auth.displayErrorMessage(Auth.responseCode) ;

    }

    /**
     * Displays the list of tickets
     */
    public void displayTicketsList(){
        displayHeader();
        for(int i =0;i <tickets.length; i++){
            displayTickets(tickets[i]);
        }
    }

    /**
     * Display ticket details
     * @param ticket - ticket object that contains all the ticket details
     */
    public void displayTickets(Ticket ticket){

        String subject = "";
        String description = "";

        if(ticket.getSubject().length() >20)
            subject = stringFormatter(ticket.getSubject(), 20);
        if(ticket.getSubject().length() >40)
            description = stringFormatter(ticket.getDescription(), 40);

        System.out.format("| %-10s | %-10s | %-10s | %-40s | %-50s | %-10s |\n", ticket.getId(), ticket.getStatus(), ticket.getPriority() , subject, description, ticket.getCreatedAt());
    }

    /**
     * Display header
     */
    public void displayHeader(){
        System.out.println(" ------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("| %-10s | %-10s | %-10s | %-10s | %-10s | %-10s |\n", "ID", "Status","Priority", "Subject" ,"Description", "Created");
        System.out.println(" ------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void displayPageNo(int page){
        System.out.println("Page No: "+page);
    }

    public String stringFormatter(String str, int limiter){
            str = str.substring(0,limiter) + "...";
            return str;
    }

}
