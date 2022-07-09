package ru.netology.comparator;

import ru.netology.domain.Tickets;

import java.util.Comparator;

public class TicketsComparator implements Comparator<Tickets> {
    @Override
    public int compare(Tickets o1, Tickets o2) {
        if (o1.getTravelTime() < o2.getTravelTime()) {
            return -1;
        } else if (o1.getTravelTime() > o2.getTravelTime()) {
            return 1;
        } else {
            return 0;
        }
    }
}
