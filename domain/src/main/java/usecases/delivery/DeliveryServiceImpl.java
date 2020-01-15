package usecases.delivery;

import com.google.inject.name.Named;
import models.Delivery;
import models.DeliveryRoute;
import models.Instruction;
import usecases.instruction.InstructionService;

import javax.inject.Inject;
import java.util.stream.Collectors;

public class DeliveryServiceImpl implements DeliveryService {

    private InstructionService instructionService;

    @Inject
    public DeliveryServiceImpl(@Named("InstructionService") InstructionService instructionService) {
        this.instructionService = instructionService;
    }

    @Override
    public Delivery deliverOrder(Delivery delivery) {
        for (DeliveryRoute deliveryRoute : delivery.getDeliveryOrder()) {
            delivery.setDrone(instructionService.executeInstructions(delivery.getDrone(),
                    deliveryRoute
                            .getOptions()
                            .stream()
                            .map(Instruction::getInstructionByCode).collect(Collectors.toList())));
            delivery.getDeliveryReport().add(delivery.getDrone().toString());
        }
        return delivery;
    }
}
