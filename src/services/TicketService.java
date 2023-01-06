package services;

import models.*;
import repositories.ParkingLotRepository;
import repositories.TicketRepository;
import strategies.spotassignmentstrategy.SpotAssignmentStrategy;

import java.util.Date;

public class TicketService {

    private TicketRepository ticketRepository;
    private SpotAssignmentStrategy spotAssignmentStrategy;
    private ParkingLotRepository parkingLotRepository;

    public TicketService(TicketRepository ticketRepository,
                         SpotAssignmentStrategy spotAssignmentStrategy,
                         ParkingLotRepository parkingLotRepository) {
        this.ticketRepository = ticketRepository;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
        this.parkingLotRepository = parkingLotRepository;
    }

    public Ticket generateTicket(Long parkingLotId, Vehicle vehicle, SpotType spotType, EntryGate entryGate) {
        // 1. Find a spot
        //
        ParkingLot parkingLot = parkingLotRepository.getById(parkingLotId);

        ParkingSpot parkingSpot = spotAssignmentStrategy.assignSpot(parkingLot, spotType, entryGate);

        if (parkingLot == null) {
            return null;
        }

        Ticket ticket = new Ticket();
        ticket.setEntryGate(entryGate);
        ticket.setGeneratedByOperator(entryGate.getOperator());
        ticket.setParkingSpot(parkingSpot);
        ticket.setVehicle(vehicle);
        ticket.setEntryTime(new Date());

        return ticket;
    }

}
