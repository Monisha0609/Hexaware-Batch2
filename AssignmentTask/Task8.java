package com.hexaware;

class Courier {
    int id;
    String name;
    boolean isAvailable;
    double x, y; // Courier's location coordinates

    public Courier(int id, String name, boolean isAvailable, double x, double y) {
        this.id = id;
        this.name = name;
        this.isAvailable = isAvailable;
        this.x = x;
        this.y = y;
    }
}

public class Task8 {

    public static Courier findNearestCourier(double orderX, double orderY, Courier[] couriers) {
        Courier nearest = null;
        double minDistance = Double.MAX_VALUE;

        for (Courier courier : couriers) {
            if (courier.isAvailable) {
                double distance = Math.sqrt(Math.pow(courier.x - orderX, 2) + Math.pow(courier.y - orderY, 2));
                if (distance < minDistance) {
                    minDistance = distance;
                    nearest = courier;
                }
            }
        }

        return nearest;
    }

    public static void main(String[] args) {
        Courier[] couriers = {
            new Courier(1, "Ram", true, 2.0, 3.0),
            new Courier(2, "Sitha", false, 5.0, 5.0),
            new Courier(3, "Kohli", true, 1.0, 1.0),
            new Courier(4, "Sam", true, 10.0, 10.0)
        };

        double orderX = 2.0;
        double orderY = 2.0;

        Courier nearest = findNearestCourier(orderX, orderY, couriers);
        if (nearest != null) {
            System.out.println("Nearest available courier is: " + nearest.name + " (ID: " + nearest.id + ")");
        } else {
            System.out.println("No available couriers found.");
        }
    }
}
