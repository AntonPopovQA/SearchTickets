package ru.netology.repository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Tickets;
import ru.netology.exceptions.*;

public class TicketRepositoryTest {
    TicketsRepository repo = new TicketsRepository();

    Tickets ticket1 = new Tickets(10, 1_000, "LED", "MSQ", 120);
    Tickets ticket2 = new Tickets(11, 2_000, "LED", "HEL", 130);
    Tickets ticket3 = new Tickets(12, 3_000, "LED", "NYO", 160);
    Tickets ticket4 = new Tickets(13, 4_000, "LED", "SYX", 200);
    Tickets ticket5 = new Tickets(14, 5_000, "LED", "HND", 240);

    @Test
    public void emptyRepo() {

        Tickets[] expected = {};
        Tickets[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveOneTicket() {
        repo.save(ticket1);

        Tickets[] expected = {ticket1};
        Tickets[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveThreeTickets() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);

        Tickets[] expected = {ticket1, ticket2, ticket3};
        Tickets[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdTicket() {
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.removeById(12);

        Tickets[] expected = {ticket4, ticket5};
        Tickets[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
// Исключения
    @Test
    public void shouldRemoveByIdNotFoundException() {
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(5);
        });
    }
    @Test
    public void shouldSaveAlreadyExistsException() {
        repo.save(ticket1);
        repo.save(ticket4);
        repo.save(ticket5);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.save(ticket1);
        });
    }
}
