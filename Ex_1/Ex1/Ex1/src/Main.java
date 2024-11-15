import FlightSystem.Data.Airline;
import FlightSystem.Data.Component;
import FlightSystem.Data.Flight;
import FlightSystem.FlightSystem;
import FlightSystem.Notifications.*;
import FlightSystem.Search.DepartureTimeSearch;
import FlightSystem.Search.FlightNumberSearch;
import FlightSystem.Search.MaxPriceSearch;
import FlightSystem.Search.SearchStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Main {
    public static List<Component> createDummyAirlines(int nAirlines, int nFlightsEach, int nSubAirlines, int nSubAirlinesFlightsEach) {
        List<Component> airlines = new ArrayList<>();
        Random random = new Random();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm"); // Format to display hours and minutes

        for (int i = 0; i < nAirlines; i++) {
            airlines.add(new Airline("Airline " + i));

            for (int j = 0; j < nFlightsEach; j++) {
                int departureHour = random.nextInt(24); // Random hour between 0 and 23
                int arrivalHour = (departureHour + 1 + random.nextInt(23)) % 24; // Random hour between 1 to 24 after departure

                ((Airline) airlines.get(i)).addComponent(
                        new Flight(
                                departureHour,
                                arrivalHour,
                                j,
                                "Country " + j,
                                "Country " + j + 1
                        )
                );
            }

            for (int j = 0; j < nSubAirlines; j++) {
                Airline sub = new Airline("Airline " + j + 10);
                for (int k = 0; k < nSubAirlinesFlightsEach; k++) {
                    int departureHour = random.nextInt(24); // Random hour between 0 and 23
                    int arrivalHour = (departureHour + 1 + random.nextInt(23)) % 24; // Random hour between 1 to 24 after departure

                    ((Airline) airlines.get(i)).addComponent(
                            new Flight(
                                    departureHour,
                                    arrivalHour,
                                    j,
                                    "Country " + j,
                                    "Country " + j + 1
                            )
                    );
                }
                ((Airline) airlines.get(i)).addComponent(sub);
            }
        }


        return airlines;
    }


    public static void main(String[] args) {
        List<Component> components = createDummyAirlines(3, 4, 5, 6);
        FlightSystem s = new FlightSystem(components);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Search flights");
            System.out.println("2. Display all data");
            System.out.println("3. Get notifications on flights");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // newline

            switch (choice) {
                case 1:
                    System.out.println("1. Filter by max price");
                    System.out.println("2. Filter by min departure time (Type time in integer - 2, 14, 20 etc). 00 the first flight to 23:");
                    System.out.print("Enter your choice: ");
                    int filterChoice = scanner.nextInt();

                    System.out.print("Enter value: ");
                    int value = scanner.nextInt();

                    SearchStrategy strategy = switch (filterChoice) {
                        case 1 -> new MaxPriceSearch(value);
                        case 2 -> new DepartureTimeSearch(value);
                        case 3 -> new FlightNumberSearch(value); ///////////
                        default -> null;
                    };

                    List<Flight> filteredFlights = s.searchFlightsBy(strategy);
                    for (Flight flight : filteredFlights)
                        System.out.println(flight.toString());
                    break;
                case 2:
                    s.displayComponents();
                    break;
                case 3:
                    s.displayComponents();
                    System.out.print("Enter a flight id from the above list: ");
                    int chosenFlightId = scanner.nextInt();
                    Flight chosenFlight = s.searchFlightsBy(new FlightNumberSearch(chosenFlightId)).get(0);

                    System.out.print("Enter a subject you would like to observe: ");
                    System.out.println("1. Arrival Time change");
                    System.out.println("2. Departure Time change");
                    System.out.println("3. Price change");
                    System.out.print("Enter your choice: ");
                    int observerChoice = scanner.nextInt();
                    Observer<Flight> observer = switch (observerChoice) {
                        case 1 -> new ArrivalTimeObserver();
                        case 2 -> new DepartureTimeObserver();
                        case 3 -> new PriceObserver();
                        default -> null;
                    };

                    FlightSubject flightSubject = new FlightSubject(chosenFlight);
                    flightSubject.addObserver(observer);

                    s.addListener(flightSubject);
            }
        }
    }
}