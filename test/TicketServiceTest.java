import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TicketServiceTest {

    @org.junit.jupiter.api.Test
    void test1() throws ParseException {
        TicketService ts = new TicketService();
        ts.addFlights();
        ts.userInformation1("alex","thessaloniki","london", LocalDate.of(2023, 6, 28),LocalDate.of(2023, 6, 28));
        ArrayList<Flight> flights = ts.searchFlight();



        assertEquals(2,flights.size());
    }

    @org.junit.jupiter.api.Test
    void test2() throws ParseException {
        TicketService ts = new TicketService();
        ts.addFlights();
        ts.userInformation1("alex","london","thessaloniki", LocalDate.of(2023, 7, 28),LocalDate.of(2023, 7, 28));
        ArrayList<Flight> flights = ts.searchFlight();



        assertEquals(0,flights.size());
    }

    @org.junit.jupiter.api.Test
    void test3() throws ParseException {
        TicketService ts = new TicketService();
        ts.addFlights();
        ts.userInformation1("alex","germany","norway", LocalDate.of(2023, 6, 28),LocalDate.of(2023, 7, 28));
        ArrayList<Flight> flights = ts.searchFlight();



        assertEquals(2,flights.size());
    }

}