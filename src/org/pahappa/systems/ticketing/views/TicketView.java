package org.pahappa.systems.ticketing.views;

import org.pahappa.systems.ticketing.services.TicketService;
import org.pahappa.systems.ticketing.services.impl.TicketServiceImpl;
import org.pahappa.systems.ticketing.models.Ticket;
import org.pahappa.systems.ticketing.constants.TicketStatus;
import org.pahappa.systems.ticketing.constants.TicketCategory;

import java.util.Scanner;

public class TicketView implements BaseTicketView {

    private final TicketService ticketService;
    private final Scanner scanner;

    public TicketView() {
        this.ticketService = new TicketServiceImpl();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void displayMenu() {
        System.out.println("********* Call Center Ticket System *********\n\n");
        boolean running = true;
        while (running) {
            System.out.println("Choose an operation:");
            System.out.println("1. Create Ticket");
            System.out.println("2. Get All Tickets");
            System.out.println("3. Get Tickets of Status");
            System.out.println("4. Update Ticket");
            System.out.println("5. Delete Ticket");
            System.out.println("6. Exit");
            System.out.println();

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            
            switch (choice) {
                case 1:
                    createTicket();
                    break;
                case 2:
                    getAllTickets();
                    break;
                case 3:
                    getTicketsOfStatus();
                    break;
                case 4:
                    updateTicket();
                    break;
                case 5:
                    deleteTicket();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");

            }
        }
    }

    @Override
    public void createTicket(){
        Scanner sc = new Scanner(System.in);
            System.out.println("******ENTER ALL INFORMATION CORRECTLY***");
            System.out.print("Enter Customer ID :");
            String id = sc.nextLine();
            System.out.print("Enter Customer Contact :");
            String contact = sc.nextLine();

            System.out.print("Enter Issue :");
            String issue = sc.nextLine();

            System.out.println("\n**Enter Ticket Category**");
            for (TicketCategory cat : TicketCategory.values()) {
                System.out.println(cat.ordinal() +" "+ cat.name());
            }
            TicketCategory tcat = null;
            for(;;){
                System.out.println("Choose Category: ");
                int category = sc.nextInt();
                if(category==0){
                    tcat = TicketCategory.COMPLAINT;
                }else if(category==1){
                    tcat = TicketCategory.INQUIRY;
                }else{
                System.out.println("Invalid input");
                continue;
                }
                break;
            }
            
            System.out.println("\n**Choose Priority Level**");
            System.out.println("1. LOW");
            System.out.println("2. MID");
            System.out.println("3. HIGH");
            int priority = sc.nextInt();

            System.out.println("\n**Enter Ticket Category**");
            for (TicketStatus sta : TicketStatus.values()) {
                System.out.println(sta.ordinal() +" "+ sta.name());
            }
            TicketStatus stat = null;
            for(;;){
                System.out.println("Choose Status: ");
                int state = sc.nextInt();
                if(state==0){
                stat = TicketStatus.OPEN;
                }else if(state==1){
                stat = TicketStatus.INPROGRESS;
                }else if(state==2){
                stat = TicketStatus.RESOLVED;
                }else{
                System.out.println("Invalid input");
                continue;
                }
                break;
            }
            String prior=null;
            switch(priority) {
                case 1: {
                    prior = "LOW";
                    break;
                }
                case 2: {
                    prior = "MID";
                    break;
                }
                case 3: {
                    prior = "HIGH"; 
                    break;
                }
                default :{
                    System.out.println("Enter correct option");
                    break;
                }
            }
            
            Ticket ticket = new Ticket(null,id,contact,tcat,issue,prior,stat);
            System.out.println(ticket.customerID + " "+ ticket.contact +" "+tcat+" "+issue+" "+prior+" "+stat);
            ticketService.createTicket(ticket);
            
        
    }

    @Override
    public void getAllTickets() {

    }

    @Override
    public void getTicketsOfStatus() {

    }

    @Override
    public void updateTicket() {

    }

    @Override
    public void deleteTicket() {

    }
}
