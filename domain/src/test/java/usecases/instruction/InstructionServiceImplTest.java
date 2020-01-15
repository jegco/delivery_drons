package usecases.instruction;

import models.Drone;
import models.Instruction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InstructionServiceImplTest {

    private InstructionService instructionService;
    private Drone drone;
    private List<Instruction> instructions;


    @Before
    public void setup() {
        instructionService = new InstructionServiceImpl();
        drone = new Drone("000", 3);
        instructions = new ArrayList<>();
        instructions.add(Instruction.A);
        instructions.add(Instruction.A);
        instructions.add(Instruction.A);
        instructions.add(Instruction.A);
        instructions.add(Instruction.I);
        instructions.add(Instruction.A);
        instructions.add(Instruction.A);
        instructions.add(Instruction.D);
    }

    @Test
    public void executeInstructions() {
        instructionService.executeInstructions(drone, instructions);
        Assert.assertEquals(2, drone.getCapacity());
    }
}