package usecases.instruction;

import models.Drone;
import models.Instruction;

import java.util.List;

public class InstructionServiceImpl implements InstructionService {

    public InstructionServiceImpl() {
    }

    public Drone executeInstructions(Drone drone, List<Instruction> instructions) {
        instructions.forEach(instruction -> {
            if (instruction != null)
                switch (instruction) {
                    case A:
                        drone.moveForward();
                        break;
                    case D:
                        drone.rotateRight();
                        break;
                    case I:
                        drone.rotateLeft();
                        break;
                }
        });
        drone.setCapacity(drone.getCapacity() - 1);
        return drone;
    }
}
