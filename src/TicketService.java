import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

class Flight {

    String airline;
    LocalDate date;
    double cost;
    Duration duration;
    String from;
    String to;
    int seats;
    int usedSeats;

    public Flight(String airline, LocalDate date, double cost, Duration duration, String from, String to, int seats) {
        this.airline = airline;
        this.date = date;
        this.cost = cost;
        this.duration = duration;
        this.from = from;
        this.to = to;
        this.seats = seats;
        this.usedSeats=0;
    }

    public int getUsedSeats() {
        return usedSeats;
    }

    public void setUsedSeats(int usedSeats) {
        this.usedSeats = usedSeats;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}

public class TicketService {
    double profit;
    String name;
    String from;
    String to;
    LocalDate startDate;
    LocalDate endDate;
    ArrayList<Flight> flights = new ArrayList<>();

    public static void main(String[] args) throws ParseException {

        TicketService ticketService = new TicketService();
        ticketService.addFlights();
        ticketService.userInformation();
        ticketService.searchFlight();



    }

    public void userInformation() throws ParseException {

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        System.out.println("Enter name, from, to, date");
        name = myObj.nextLine();
        from = myObj.nextLine();
        to = myObj.nextLine();

        System.out.println("begin date should be year-month-day");
        String strDate = myObj.nextLine();  // Read user input

        startDate = LocalDate.parse(strDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println("end date should be  year-month-day");
        strDate = myObj.nextLine();  // Read user input

        endDate = LocalDate.parse(strDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        System.out.println(startDate);

        System.out.println("name is: " + name + " from: " + from + " to: " + to + " on the date of: " + startDate);  // Output user input

    }
    public void userInformation1(String name,String from, String to,LocalDate startDate, LocalDate endDate){
        this.name = name;
        this.from = from;
        this.to = to;
        this.startDate = startDate;
        this.endDate = endDate;

    }

    public void addFlights() {

        Flight flight1 = new Flight("ryanAIR", LocalDate.of(2023, 6, 28), 30.0, Duration.parse("PT2H30M"), "thessaloniki", "london", 100);
        flights.add(flight1);
        Flight flight2 = new Flight("easyJet", LocalDate.of(2023, 6, 28), 39.0, Duration.parse("PT2H"), "thessaloniki", "london", 100);
        flights.add(flight2);
        Flight flight3 = new Flight("aegean", LocalDate.of(2023, 7, 5), 35.0, Duration.parse("PT2H"), "thessaloniki", "london", 100);
        flights.add(flight3);
        Flight flight4 = new Flight("ryanAIR", LocalDate.of(2023, 6, 28), 30.0, Duration.parse("PT2H30M"), "london", "thessaloniki", 100);
        flights.add(flight4);
        Flight flight5 = new Flight("aegean", LocalDate.of(2023, 6, 29), 38.0, Duration.parse("PT1H30M"), "germany", "norway", 100);
        flights.add(flight5);
        Flight flight6 = new Flight("easyJet", LocalDate.of(2023, 6, 29), 35.0, Duration.parse("PT1H35M"), "germany", "norway", 100);
        flights.add(flight6);


    }

    public ArrayList<Flight> searchFlight() {
        ArrayList<Flight> results = new ArrayList<>();
        ArrayList<Integer> ids = new ArrayList<>();
        for (Flight flight : flights) {
            if (!from.equals(flight.from)) continue;
            if (!to.equals(flight.to)) continue;
            if (startDate.isAfter(flight.date) ) continue;
            if (endDate.isBefore(flight.date) ) continue;

            System.out.println("flights available "+flight.airline+" date "+flight.date+" cost "+flight.cost+" duration "+flight.duration+" ID of flight : "+flights.indexOf(flight));
            ids.add(flights.indexOf(flight));

            results.add(flight);
            // use number for id and call arraylist function book ticket
        }
        bookFlight();
        return results;
    }
    public void bookFlight() {
        //Scanner myObj = new Scanner(System.in);
        Integer booking;
        System.out.println(" Select the flight you would like to book with ID of flight ");
        booking = 1;//Integer.valueOf(myObj.nextLine());
        profit =profit+flights.get(booking).cost;
        int temp = flights.get(booking).seats;
        System.out.println("passenger "+name+" ");
        flights.get(booking).setSeats(temp-1);




    }

}