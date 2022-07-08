package ru.netology.domain;
import java.util.Comparator;
public class Tickets implements Comparable<Tickets> {
    private int id;
    private int cost;
    private String from;
    private String to;
    private int travelTime;


    public Tickets(int id, int cost, String from, String to, int travelTime) {
        this.id = id;
        this.cost = cost;
        this.from = from;
        this.to = to;
        this.travelTime = travelTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String departure) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String arrival) {
        this.to = arrival;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    @Override
    public int compareTo(Tickets o) {
        if (this.cost < o.cost) {
            return -1;
        } else if (this.cost > o.cost) {
            return 1;
        } else {
            return 0;
        }
    }
}
