package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketManagerTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(100, 10000, "SVO", "LED", "400");
    Ticket ticket2 = new Ticket(101, 70000, "LED", "GOJ", "500");
    Ticket ticket3 = new Ticket(102, 3000, "SVO", "LED", "600");
    Ticket ticket4 = new Ticket(103, 40000, "LED", "GOJ", "700");
    Ticket ticket5 = new Ticket(104, 50000, "LED", "GOJ", "800");
    Ticket ticket6 = new Ticket(105, 80000, "SVO", "GOJ", "900");
    Ticket ticket7 = new Ticket(106, 80000, "SVO", "GOJ", "1000");


    @BeforeEach
    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
    }

//    Кроме того, результаты должны быть отсортированы по цене (от меньшей к большей).


    @Test
    public void mustFindTicketsWithMatchingParametersFromAndTo() {

        Ticket[] expected = {ticket3, ticket1};
        Ticket[] actual = manager.searchBy("SVO", "LED");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindSuitableResults() {

        Ticket[] expected = {};
        Ticket[] actual = manager.searchBy("LED", "SVO");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTicketsByCost() {

        Ticket[] expected = {ticket4, ticket5, ticket2};
        Ticket[] actual = manager.searchBy("LED", "GOJ");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTicketsWithTheSameCost() {

        Ticket[] expected = {ticket6, ticket7};
        Ticket[] actual = manager.searchBy("SVO", "GOJ");

        Assertions.assertArrayEquals(expected, actual);
    }
}
