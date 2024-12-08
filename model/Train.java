```java
package model;

public class Train {
    private String trainNumber;
    private String trainName;
    private String source;
    private String destination;
    private String departureTime;
    private String arrivalTime;
    private int totalSeats;
    private int availableSeats;
    private double fare;

    // Constructor
    public Train(String trainNumber, String trainName, String source, String destination,
                String departureTime, String arrivalTime, int totalSeats, double fare) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        this.fare = fare;
    }

    // Getters and Setters
    public String getTrainNumber() { return trainNumber; }
    public void setTrainNumber(String trainNumber) { this.trainNumber = trainNumber; }
    
    public String getTrainName() { return trainName; }
    public void setTrainName(String trainName) { this.trainName = trainName; }
    
    // Add remaining getters and setters

    public boolean hasAvailableSeats() {
        return availableSeats > 0;
    }

    public void decreaseAvailableSeats() {
        if (availableSeats > 0) {
            availableSeats--;
        }
    }
}
```