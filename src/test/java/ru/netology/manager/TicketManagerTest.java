package ru.netology.manager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Tickets;
import ru.netology.repository.TicketsRepository;

public class TicketManagerTest {
    TicketsRepository repo = new TicketsRepository();
    TicketsManager manager = new TicketsManager(repo);

    Tickets ticket1 = new Tickets(10, 1_000, "LED", "MSQ", 120);
    Tickets ticket2 = new Tickets(11, 2_000, "LED", "NYO", 130);
    Tickets ticket3 = new Tickets(12, 3_000, "LED", "NYO", 160);
    Tickets ticket4 = new Tickets(13, 4_000, "LED", "SYX", 180);
    Tickets ticket5 = new Tickets(14, 5_000, "LED", "NYO", 200);

    @BeforeEach
    public void setUp() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
    }

    @Test
    public void shouldSearchOneTicket() {

        Tickets[] expected = {ticket1};
        Tickets[] actual = manager.search("LED", "MSQ");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchTwoTickets() {

        Tickets[] expected = {ticket2, ticket3, ticket5};
        Tickets[] actual = manager.search("LED", "NYO");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldNoTickets() {

        Tickets[] expected = {};
        Tickets[] actual = manager.search("LED", "CEK");

        Assertions.assertArrayEquals(expected, actual);
    }
}
