package driver.mapper;

import driver.model.Ticket;
import driver.model.Via;
import driver.service.ProcessedTicketList;
import org.json.JSONObject;
import org.json.JSONArray;

public class TicketMapper {

    public Ticket parseOneTicket(String jsonContent){
        try{
            JSONObject ticketEntities = new JSONObject(jsonContent);
            JSONObject oneTicket = ticketEntities.optJSONObject("ticket");

            if(oneTicket.length() == 0){
                System.out.println("Could not find a relevant record..!!");
                return null;
            }
            return jsonToTicketMapper(oneTicket);
        }catch(Exception e){
            System.out.println("Internal error: Sometimes life happens..!! please try again");
            return null;
        }
    }

    public ProcessedTicketList parseAllTickets(String jsonResponse){

        return new ProcessedTicketList();
    }

    public Ticket jsonToTicketMapper(JSONObject ticketContent){
        Ticket ticket = new Ticket();

        if(ticketContent == null)
            return null;

        ticket.setUrl(ticketContent.optString("url"));
        ticket.setId(ticketContent.optLong("id"));
        ticket.setExternalId(ticketContent.optString("external_id"));

        JSONObject viaContent = ticketContent.optJSONObject("via");

        if(viaContent != null){
            ticket.setVia(new Via());
            ticket.getVia().setChannel(viaContent.optString("channel"));
            JSONObject sourceContent = ticketContent.optJSONObject("source");

            if(sourceContent != null){
                ticket.getVia().getSource().setFrom(sourceContent.optJSONObject("from"));
                ticket.getVia().getSource().setTo(sourceContent.optJSONObject("to"));
                ticket.getVia().getSource().setRel(sourceContent.optJSONObject("rel"));
            }
        }

        ticket.setCreatedAt(ticketContent.optString("created_at"));
        ticket.setUpdatedAt(ticketContent.optString("updated_at"));
        ticket.setType(ticketContent.optString("type"));
        ticket.setSubject(ticketContent.optString("subject"));
        ticket.setRawSubject(ticketContent.optString("raw_subject"));
        ticket.setDescription(ticketContent.optString("description"));
        ticket.setPriority(ticketContent.optString("priority"));
        ticket.setStatus(ticketContent.optString("status"));
        ticket.setRecipient(ticketContent.optString("receipient"));
        ticket.setRequestorId(ticketContent.optLong("requester_id"));
        ticket.setSubmitterId(ticketContent.optLong("submitter_id"));
        ticket.setAssigneeId(ticketContent.optLong("assignee_id"));
        ticket.setOrganizationId(ticketContent.optLong("organization_id"));
        ticket.setGroupId(ticketContent.optLong("group_id"));

        JSONArray collabids = ticketContent.optJSONArray("collaborator_ids");
        long[] collabArr = new long[collabids.length()];
        if(collabids.length()!=0){
            for(int collabid = 0; collabid < collabids.length(); collabid++){
                collabArr[collabid] = collabids.optLong(collabid);
            }
            ticket.setCollaboratorsIds(collabArr);
        }

        JSONArray followerids = ticketContent.optJSONArray("follower_ids");
        long[] followerArr = new long[followerids.length()];
        if(followerids.length()!=0){
            for(int followerid = 0; followerid < followerids.length(); followerid++){
                followerArr[followerid] = followerids.optLong(followerid);
            }
        }

        /*JSONArray collabids = ticketContent.optJSONArray("collaborator_ids");
        long[] collabArr = new long[collabids.length()];
        if(collabids.length()!=0){
            for(int collabid = 0; collabid < collabids.length(); collabid++){
                collabArr[collabid] = collabids.optLong(collabid);
            }
        }*/

        return ticket;
    }
}
