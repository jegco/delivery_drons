package usecases.instruction;

import models.Drone;
import models.Instruction;

import java.util.List;

public interface InstructionService {
    Drone executeInstructions(Drone drone, List<Instruction> instruction);
}
