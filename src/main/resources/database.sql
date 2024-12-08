```sql
-- Create the database
CREATE DATABASE IF NOT EXISTS railway_system;
USE railway_system;

-- Create Users table
CREATE TABLE users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(15),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create Trains table
CREATE TABLE trains (
    train_number VARCHAR(10) PRIMARY KEY,
    train_name VARCHAR(100) NOT NULL,
    source VARCHAR(50) NOT NULL,
    destination VARCHAR(50) NOT NULL,
    departure_time TIME NOT NULL,
    arrival_time TIME NOT NULL,
    total_seats INT NOT NULL,
    available_seats INT NOT NULL,
    fare DECIMAL(10,2) NOT NULL
);

-- Create Bookings table
CREATE TABLE bookings (
    booking_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    train_number VARCHAR(10),
    booking_date DATE NOT NULL,
    booking_type VARCHAR(20) NOT NULL,
    total_fare DECIMAL(10,2) NOT NULL,
    status VARCHAR(20) DEFAULT 'CONFIRMED',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (train_number) REFERENCES trains(train_number)
);

-- Create Passengers table
CREATE TABLE passengers (
    passenger_id INT PRIMARY KEY AUTO_INCREMENT,
    booking_id INT,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    gender VARCHAR(10) NOT NULL,
    id_proof VARCHAR(50),
    contact_number VARCHAR(15),
    FOREIGN KEY (booking_id) REFERENCES bookings(booking_id)
);

-- Insert sample train data
INSERT INTO trains (train_number, train_name, source, destination, departure_time, arrival_time, total_seats, available_seats, fare)
VALUES 
('12345', 'Rajdhani Express', 'Delhi', 'Mumbai', '16:00', '08:00', 500, 500, 1500.00),
('12346', 'Shatabdi Express', 'Mumbai', 'Bangalore', '08:00', '18:00', 400, 400, 1200.00),
('12347', 'Duronto Express', 'Chennai', 'Kolkata', '20:00', '10:00', 450, 450, 1300.00);
```