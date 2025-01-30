package com.day1.level1;
import java.text.SimpleDateFormat;
import java.util.Date;

class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    //Constructor to initialize value
    public Ticket(int ticketId, String customerName, String movieName, String seatNumber) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        this.next = null;
    }
}

class TicketList {
    Ticket head;

    public TicketList() {
        this.head = null;
    }

    // Add a new ticket reservation at the end of the circular linked list
    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber);
        if (head == null) {
            head = newTicket;
            newTicket.next = head;
        } else {
            Ticket temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTicket;
            newTicket.next = head;
        }
        System.out.println("Ticket booked successfully for " + customerName + " for the movie " + movieName);
    }

    // Remove a ticket by Ticket ID
    public void removeTicketById(int ticketId) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        // If the head is the ticket to be removed
        if (head.ticketId == ticketId) {
            if (head.next == head) {
                // Only one ticket in the list
                head = null;
            } else {
                Ticket temp = head;
                while (temp.next != head) {
                    temp = temp.next;
                }
                head = head.next;
                temp.next = head;
            }
            System.out.println("Ticket with ID " + ticketId + " removed successfully.");
            return;
        }

        // Search for the ticket to remove
        Ticket temp = head;
        while (temp.next != head && temp.next.ticketId != ticketId) {
            temp = temp.next;
        }
        if (temp.next == head) {
            System.out.println("Ticket with ID " + ticketId + " not found.");
        } else {
            temp.next = temp.next.next; // Remove the node
            System.out.println("Ticket with ID " + ticketId + " removed successfully.");
        }
    }

    // Display the current tickets in the list
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket temp = head;
        do {
            System.out.println("Ticket ID: " + temp.ticketId + ", Customer: " + temp.customerName +
                    ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Booking Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for a ticket by Customer Name or Movie Name
    public void searchTicket(String searchTerm) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket temp = head;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(searchTerm) || temp.movieName.equalsIgnoreCase(searchTerm)) {
                System.out.println("Ticket ID: " + temp.ticketId + ", Customer: " + temp.customerName +
                        ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Booking Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No ticket found with the search term: " + searchTerm);
        }
    }

    // Calculate and display the total number of booked tickets
    public void displayTotalTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Total number of booked tickets: " + count);
    }
}

public class TicketReservationSystem {
    public static void main(String[] args) {
        TicketList ticket = new TicketList();

        // Adding some ticket reservations
        ticket.addTicket(101, "Alice", "Hello", "A1");
        ticket.addTicket(102, "Bob", "Hey World", "B2");
        ticket.addTicket(103, "Charlie", "Avenger", "C3");

        // Displaying all tickets
        System.out.println("\nAll Booked Tickets:");
        ticket.displayTickets();

        // Searching for tickets by customer name or movie name
        System.out.println("\nSearching for tickets by Customer Name 'Alice':");
        ticket.searchTicket("Alice");

        System.out.println("\nSearching for tickets by Movie Name 'Avatar':");
        ticket.searchTicket("Avengers");

        // Removing a ticket by Ticket ID
        System.out.println("\nRemoving ticket with ID 102:");
        ticket.removeTicketById(102);

        // Displaying all tickets after removal
        System.out.println("\nAll Booked Tickets after Removal:");
        ticket.displayTickets();

        // Displaying total number of booked tickets
        ticket.displayTotalTickets();
    }
}


