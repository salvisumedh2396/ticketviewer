package TestDriver.Mapper;

import driver.mapper.TicketMapper;
import driver.model.Ticket;
import driver.service.ProcessedTicketList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TicketMapperTest {

    @Test
    public void parseOneTicket(){
        String jsonContent = "{\"ticket\":{\"url\":\"https://zcctcviewer.zendesk.com/api/v2/tickets/44.json\",\"id\":44,\"external_id\":null,\"via\":{\"channel\":\"api\",\"source\":{\"from\":{},\"to\":{},\"rel\":null}},\"created_at\":\"2021-11-20T22:29:18Z\",\"updated_at\":\"2021-11-20T22:29:18Z\",\"type\":null,\"subject\":\"amet ipsum amet laborum sit\",\"raw_subject\":\"amet ipsum amet laborum sit\",\"description\":\"Eu aute minim ullamco laborum mollit magna id laboris. Dolor do laborum aliquip cupidatat. Magna cupidatat tempor do magna aliqua laborum consequat laborum consequat ex laborum dolor eu. Minim aliquip do est et pariatur duis aute ad veniam nostrud. Tempor anim ipsum esse fugiat labore veniam ex. Tempor ad nostrud officia deserunt consequat culpa sint magna.\\n\\nMagna elit sit ipsum sint. Lorem et consectetur ipsum laborum laboris duis pariatur id reprehenderit id. Non pariatur incididunt culpa ipsum sint excepteur duis aliquip. Consectetur anim exercitation dolor magna occaecat eiusmod officia eu consectetur ex. Velit incididunt ullamco tempor adipisicing sint sunt fugiat anim eu minim fugiat proident.\",\"priority\":null,\"status\":\"open\",\"recipient\":null,\"requester_id\":1909909136305,\"submitter_id\":1909909136305,\"assignee_id\":1909909136305,\"organization_id\":1500625577182,\"group_id\":1500006580962,\"collaborator_ids\":[],\"follower_ids\":[],\"email_cc_ids\":[],\"forum_topic_id\":null,\"problem_id\":null,\"has_incidents\":false,\"is_public\":true,\"due_at\":null,\"tags\":[\"eu\",\"nulla\",\"reprehenderit\"],\"custom_fields\":[],\"satisfaction_rating\":null,\"sharing_agreement_ids\":[],\"fields\":[],\"followup_ids\":[],\"ticket_form_id\":1500003364302,\"brand_id\":1500002335782,\"allow_channelback\":false,\"allow_attachments\":true}}";
        TicketMapper parseTicket = new TicketMapper();
        Ticket ticket = new Ticket();

        ticket = parseTicket.parseOneTicket(jsonContent);
        assertEquals(44L,ticket.getId());
    }

    @Test
    public void parseTicketList(){
        String jsonContent = "{\"ticket\":{\"url\":\"https://zcctcviewer.zendesk.com/api/v2/tickets/44.json\",\"id\":44,\"external_id\":null,\"via\":{\"channel\":\"api\",\"source\":{\"from\":{},\"to\":{},\"rel\":null}},\"created_at\":\"2021-11-20T22:29:18Z\",\"updated_at\":\"2021-11-20T22:29:18Z\",\"type\":null,\"subject\":\"amet ipsum amet laborum sit\",\"raw_subject\":\"amet ipsum amet laborum sit\",\"description\":\"Eu aute minim ullamco laborum mollit magna id laboris. Dolor do laborum aliquip cupidatat. Magna cupidatat tempor do magna aliqua laborum consequat laborum consequat ex laborum dolor eu. Minim aliquip do est et pariatur duis aute ad veniam nostrud. Tempor anim ipsum esse fugiat labore veniam ex. Tempor ad nostrud officia deserunt consequat culpa sint magna.\\n\\nMagna elit sit ipsum sint. Lorem et consectetur ipsum laborum laboris duis pariatur id reprehenderit id. Non pariatur incididunt culpa ipsum sint excepteur duis aliquip. Consectetur anim exercitation dolor magna occaecat eiusmod officia eu consectetur ex. Velit incididunt ullamco tempor adipisicing sint sunt fugiat anim eu minim fugiat proident.\",\"priority\":null,\"status\":\"open\",\"recipient\":null,\"requester_id\":1909909136305,\"submitter_id\":1909909136305,\"assignee_id\":1909909136305,\"organization_id\":1500625577182,\"group_id\":1500006580962,\"collaborator_ids\":[],\"follower_ids\":[],\"email_cc_ids\":[],\"forum_topic_id\":null,\"problem_id\":null,\"has_incidents\":false,\"is_public\":true,\"due_at\":null,\"tags\":[\"eu\",\"nulla\",\"reprehenderit\"],\"custom_fields\":[],\"satisfaction_rating\":null,\"sharing_agreement_ids\":[],\"fields\":[],\"followup_ids\":[],\"ticket_form_id\":1500003364302,\"brand_id\":1500002335782,\"allow_channelback\":false,\"allow_attachments\":true}}";
        TicketMapper parseTicket = new TicketMapper();
        ProcessedTicketList ticketList = new ProcessedTicketList();

        ticketList = parseTicket.parseAllTickets(jsonContent);
        assertEquals(null,ticketList);
    }

    @Test
    public void parseSingleTicketInvalidValues(){
        String jsonContent = "invalid content";
        TicketMapper parseTicket = new TicketMapper();
        Ticket ticket = new Ticket();

        ticket = parseTicket.parseOneTicket(jsonContent);
        assertEquals(null,ticket);
    }

    @Test
    public void parseTicketListInvalidValues(){
        String jsonContent = "invalid content";
        TicketMapper parseTicket = new TicketMapper();
        ProcessedTicketList ticketList = new ProcessedTicketList();

        ticketList = parseTicket.parseAllTickets(jsonContent);
        assertEquals(null,ticketList);
    }



}
