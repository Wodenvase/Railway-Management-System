```java
package controller;

import model.Train;
import model.Ticket;
import model.Passenger;
import dao.TrainDAO;
import dao.ReservationDAO;
import java.util.List;

public class BookingController {
    private TrainDAO trainDAO;
    private ReservationDAO reservationDAO;

    public BookingController() {
        trainDAO = new TrainDAO();
        reservationDAO = new ReservationDAO();
    }

    public List<Train> searchTrains(String source, String destination, String date) {
        return trainDAO.searchTrains(source, destination, date);
    }

    public Ticket bookTicket(Train train, List<Passenger> passengers, String bookingType) {
        // Validate seat availability
        if (!train.hasAvailableSeats()) {
            throw new RuntimeException("No seats available");
        }

        // Calculate fare
        double totalFare = calculateFare(train, passengers.size(), bookingType);

        // Create ticket
        Ticket ticket = new Ticket(
            train,
            passengers,
            totalFare,
            bookingType
        );

        // Save to database
        reservationDAO.saveTicket(ticket);

        // Update seat availability
        trainDAO.updateSeatAvailability(train.getTrainNumber());

        return ticket;
    }

    private double calculateFare(Train train, int passengerCount, String bookingType) {
        double baseFare = train.getFare();
        double fare = baseFare * passengerCount;

        // Apply booking type multiplier
        switch (bookingType.toLowerCase()) {
            case "tatkal":
                fare *= 1.3; // 30% premium for Tatkal
                break;
            case "premium":
                fare *= 1.2; // 20% premium for Premium
                break;
            default: // Regular booking
                break;
        }

        return fare;
    }
}
```