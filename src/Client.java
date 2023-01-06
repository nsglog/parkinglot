import controllers.ParkingLotController;
import controllers.TicketController;
import dtos.*;
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

        CreateParkingLotResponseDto responseDto = parkingLotController.createParkingLot(requestDto);

        if (responseDto.getResponseStatus().equals(ResponseStatusDto.FAILURE)) {
            System.out.println("Something is wrong");
        } else {
            System.out.println(responseDto.getResponseStatus());
        }

        UpdateParkingLotRequestDto updateParkingLotRequest = new UpdateParkingLotRequestDto();
        updateParkingLotRequest.setId(1L);
        updateParkingLotRequest.setAddress("Noida");

        UpdateParkingLotResponseDto updateResponseDto = parkingLotController.updateAddress(updateParkingLotRequest);
        System.out.println(updateResponseDto.getResponseStatus());
    }
}
