package com.week3.day2;

class CircularTour {
    static int findStartingPoint(int[] petrol, int[] distance) {
        int start = 0;
        int deficit = 0;
        int surplus = 0;
        for (int i = 0; i < petrol.length; i++) {
            surplus += petrol[i] - distance[i];
            if (surplus < 0) {
                start = i + 1;
                deficit += surplus;
                surplus = 0;  // Reset surplus
            }
        }

        return (surplus + deficit >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};
        int startPoint = findStartingPoint(petrol, distance);
        System.out.println("Starting Pump Index: " + startPoint);
    }
}
