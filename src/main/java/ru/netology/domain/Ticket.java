package ru.netology.domain;

public class Ticket implements Comparable<Ticket> {
    private int id;
    private int cost;
    private String departureAirport;
    private String arrivalAirport;
    private String travelTime;

    public Ticket(int id, int cost, String departureAirport, String arrivalAirport, String travelTime) {
        this.id = id;
        this.cost = cost;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
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

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(String travelTime) {
        this.travelTime = travelTime;
    }

    @Override
    public int compareTo(Ticket o) {
        if (this.cost < o.cost) {
            return -1;
        } else if (this.cost > o.cost) {
            return 1;
        } else {
            return 0;
        }
    }
}
//    если билет у которого вызвали метод compareTo дешевле чем тот которого передали через параметр,
//    то возвращалось бы число меньше нуля,
//    если же билет наоборот дороже, то число больше нуля, а если стоимость одинакова, то 0
