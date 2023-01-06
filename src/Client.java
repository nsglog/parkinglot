import controllers.ParkingLotController;
import controllers.TicketController;
import dtos.*;
import models.ParkingLot;
import repositories.ParkingLotRepository;
import repositories.TicketRepository;
import services.ParkingLotService;
import services.TicketService;
import strategies.spotassignmentstrategy.RandomSpotAssignmentStrategy;
import strategies.spotassignmentstrategy.SpotAssignmentStrategy;

public class Client {

    public static void main(String[] args)  {

        ObjectRegistry.put("parkingLotRepository", new ParkingLotRepository());
        ObjectRegistry.put("parkingLotService", new ParkingLotService(
                (ParkingLotRepository) ObjectRegistry.get("parkingLotRepository")
        ));
        ObjectRegistry.put("parkingLotController", new ParkingLotController(
                (ParkingLotService) ObjectRegistry.get("parkingLotService")
        ));
        ObjectRegistry.put("ticketRepository", new TicketRepository());
        ObjectRegistry.put("spotAssignmentStrategy", new RandomSpotAssignmentStrategy());
        ObjectRegistry.put("ticketService", new TicketService(
                (TicketRepository) ObjectRegistry.get("ticketRepository"),
                (SpotAssignmentStrategy) ObjectRegistry.get("spotAssignmentStrategy"),
                (ParkingLotRepository) ObjectRegistry.get("parkingLotRepository")
        ));
        ObjectRegistry.put("ticketController", new TicketController(
                (TicketService) ObjectRegistry.get("ticketService")
        ));

        ParkingLotController parkingLotController = (ParkingLotController) ObjectRegistry.get("parkingLotController");
        CreateParkingLotRequestDto requestDto = new CreateParkingLotRequestDto();
        requestDto.setAddress("Delhi Airport");
        requestDto.setNumberOfFloors(4);

        CreateParkingLotResponseDto response = parkingLotController.createParkingLot(requestDto);

        if (response.getResponseStatus().equals(ResponseStatusDto.FAILURE)) {
            System.out.println("Something is wrong");
        } else {
            System.out.println(response.getParkingLot());
        }

        UpdateParkingLotRequestDto updateParkingLotRequest = new UpdateParkingLotRequestDto();
        updateParkingLotRequest.setId(1L);
        updateParkingLotRequest.setAddress("Noida");

        UpdateParkingLotResponseDto responseDto = parkingLotController.updateAddress(updateParkingLotRequest);

        System.out.println(responseDto);
    }
}
