package driver;

import driver.controller.TicketController;
import driver.service.ProcessedTicketList;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainMenu {

    private static boolean displayMenu = true;
    private static String result;
    private static int pageNo = 1;
    private static int perPageLimit = 25;
    private static boolean isNext = false;
    private static boolean isPrevious = false;

    public static TicketController ticketController = new TicketController();
    public static ProcessedTicketList processedTicketList = new ProcessedTicketList();

    public static void main(String[] args) throws Exception{
        BufferedReader choice = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            try{
                if(displayMenu){
                    displayMenu();
                }
                String menuChoice = choice.readLine();
                switch(menuChoice){
                    case "1":
                    {
                        int ticketId = 0;
                        do {
                            System.out.println("Please enter a ticket ID: ");
                            try {
                                ticketId = Integer.parseInt(choice.readLine());
                                if(ticketId > 0){
                                    result = ticketController.showTicket(ticketId);
                                    if(!result.equals("SUCCESS")){
                                        System.out.println(result);
                                    }
                                }else{
                                    System.out.println("Could not identify ticket id. Please try again after sometime..!!");
                                }

                            } catch (NumberFormatException e) {
                                System.out.println("Invalid ticket ID, please enter ID again..!!");
                            }
                        }while(ticketId <= 0);
                        displayBackOption();
                        break;
                    }
                    case "2":
                    {
                        getPage(pageNo);
                        break;
                    }
                    case "n":
                    {
                        if(isNext != false){
                            pageNo++;
                            getPage(pageNo);
                        }else{
                            System.out.println("Cannot go to the next page. Limit reached");
                            paginationMenu();
                        }
                        break;
                    }
                    case "p":
                    {
                        if(isPrevious != false && pageNo>1){
                            pageNo--;
                            getPage(pageNo);
                        }else{
                            System.out.println("Cannot go to previous page.");
                            paginationMenu();
                        }
                        break;
                    }
                    case "back":
                    {
                        displayMenu = true;
                        pageNo = 1;
                        break;
                    }
                    case "quit":
                    {
                        System.out.println("Thank you for using Zendesk Ticket Viewer System. See you soon..!!");
                        return;
                    }
                    default:
                        System.out.println("Invalid input, please try again");
                }
            }catch (Exception e){
                System.out.println("Encountered an issue while processing. Please try again");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
            }
        }
    }

    private static void getPage(int pageNo) {
        result = ticketController.displayTicketList(perPageLimit, pageNo, processedTicketList);
        if(!result.equals("SUCCESS")){
            System.out.println(result);
        }
        isNext = processedTicketList.isNext;
        isPrevious = processedTicketList.isPrevious;
        paginationMenu();
    }

    private static void paginationMenu(){
        displayMenu = false;
        System.out.println("\nEnter 'n' to move to next page");
        System.out.println("Enter 'p' to move to previous page");
        System.out.println("Enter '1' to view single ticket details");
        System.out.println("Enter 'back' to go to the main menu");
    }

    private static void displayMenu(){
        System.out.println("\n============== Welcome to Zendesk Ticket Viewer System ============");
        System.out.println("Please select one of the options:");
        System.out.println("1: View Single ticket");
        System.out.println("2: View all tickets");
        System.out.println("Type 'quit' to exit");
    }

    private static void displayBackOption(){
        displayMenu = false;
        System.out.println("\nType 'back' to go back to the main menu");
    }
}
