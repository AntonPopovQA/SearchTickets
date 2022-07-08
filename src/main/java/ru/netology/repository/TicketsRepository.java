package ru.netology.repository;
import ru.netology.domain.Tickets;
import ru.netology.exceptions.*;
import java.nio.file.FileAlreadyExistsException;

public class TicketsRepository {

    private Tickets[] tickets = new Tickets[0];

    public void save(Tickets ticket) {
        if (findById(ticket.getId()) != null) {
            throw new AlreadyExistsException(ticket + " already exists");
        }
        Tickets[] tmp = new Tickets[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        Tickets[] tmp = new Tickets[tickets.length - 1];
        int copyToIndex = 0;
        for (Tickets ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[copyToIndex] = ticket;
                copyToIndex++;
            }
        }
        tickets = tmp;
    }
    public Tickets findById(int id) {
        for (Tickets ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public Tickets[] findAll() {
        return tickets;
    }
}

