package strategies;

import models.SlotAssignmentStrategyType;
import respositories.ParkingLotRepository;

public class SlotAssignmentStrategyFactory {

    public static SlotAssignmentStrategy getSlotAssignmentStrategyByType(SlotAssignmentStrategyType slotAssignmentStrategyType) {
        return new RandomSlotAssignmentStrategy();
    }
}
