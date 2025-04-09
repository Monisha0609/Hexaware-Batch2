//7. Create an array to store the tracking history of a parcel, where each entry represents a location update.
package com.hexaware;

import java.util.ArrayList;

class TrackingEntry {
    String timestamp;
    String location;
    String status;
    
    public TrackingEntry(String timestamp, String location, String status) {
        this.timestamp = timestamp;
        this.location = location;
        this.status = status;
    }

    @Override
    public String toString() {
        return timestamp + " - " + location + " - " + status;
    }
}

public class Task7 {
    public static void main(String[] args) {
        ArrayList<TrackingEntry> trackingHistory = new ArrayList<>();

        trackingHistory.add(new TrackingEntry("2025-04-03 10:00 AM", "10th cross road,Bangalore", "Parcel received"));
        trackingHistory.add(new TrackingEntry("2025-04-03 02:30 PM", "1st Main road,hyderabad", "In transit"));
        trackingHistory.add(new TrackingEntry("2025-04-03 06:00 PM", "2nd Cross Road,Kerala.", "Out for delivery"));

        for (TrackingEntry entry : trackingHistory) {
            System.out.println(entry);
        }
    }
}
