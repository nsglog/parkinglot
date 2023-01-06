package repositories;

import models.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {

    private Map<Long, ParkingLot> parkingLots = new HashMap<>();
    private Long indx = 0L;

    public ParkingLot save (ParkingLot parkingLot)  {
        indx ++;
        parkingLot.setId(indx);
        parkingLots.put(indx, parkingLot);
        return parkingLot;
    }

    public ParkingLot getById (Long id) {
        return parkingLots.get(id);
    }

    public ParkingLot update (Long id, ParkingLot parkingLot)   {
        parkingLots.put(id, parkingLot);
        return parkingLots.get(id);
    }
}
