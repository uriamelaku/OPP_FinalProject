package FlightSystem.Data;

import java.util.Random;

public class Flight implements Component {
    private final int flightNumber;
    private long departureTime;
    private long arrivalTime;
    private int price;
    private final String from;
    private final String to;

    public Flight(long departureTime, long arrivalTime, int price, String from, String to) {
        this.flightNumber = generateRandomFlightNumber();
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
        this.from = from;
        this.to = to;
    }
    private int generateRandomFlightNumber() {
        Random random = new Random();
        return 100000 + random.nextInt(900000); // Generates a random number between 100000 and 999999
    }


    public int getFlightNumber() {
        return flightNumber;
    }

    public long getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(long departureTime) {
        this.departureTime = departureTime;
    }

    public long getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(long arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    @Override
    public void display() {
        StringBuilder builder = new StringBuilder();
        builder.append("Flight Number: ").append(flightNumber)
                .append(" From: ").append(from)
                .append(" To: ").append(to)
                .append(" Departure Time: ").append(departureTime)
                .append(":00 Arrival Time: ").append(arrivalTime)
                .append(":00 Price: ").append(price);

        System.out.println(builder);
    }

    @Override
    public String toString() {
         return "Flight - " +
                 "flightNumber=" + flightNumber +
                 ", departureTime=" + departureTime +
                 ":00, arrivalTime=" + arrivalTime +
                 ":00, price=" + price; //
    }
}
