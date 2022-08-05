package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;
import java.util.Comparator;

public class TicketManager {

    private TicketRepository repo;

    private Ticket[] tickets = new Ticket[0];
    private Comparator<? super Ticket> compareTo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public void add(Ticket ticket) {
        repo.save(ticket);
    }

    public boolean matchesDepartureAirport(Ticket ticket, String departureAirport) {
        return ticket.getDepartureAirport().contains(departureAirport);
    }

    public boolean matchesArrivalAirport(Ticket ticket, String arrivalAirport) {
        return ticket.getArrivalAirport().contains(arrivalAirport);
    }

    public Ticket[] searchBy(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.findAll()) {
            if (matchesDepartureAirport(ticket, from))
                if (matchesArrivalAirport(ticket, to)) {
                    Ticket[] tmp = new Ticket[result.length + 1];
                    for (int i = 0; i < result.length; i++) {
                        tmp[i] = result[i];
                    }
                    tmp[tmp.length - 1] = ticket;
                    result = tmp;
                }
        }
        Arrays.sort(result);
        return result;
    }
}
