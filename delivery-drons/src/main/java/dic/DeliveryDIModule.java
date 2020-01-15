package dic;

import Interactor.base.ExpensiveInteractor;
import Interactor.base.Interactor;
import Interactor.deliveries.DeliveryInteractor;
import Interactor.files.ReadFileInteractor;
import Interactor.files.WriteFileInteractor;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;
import models.Delivery;
import models.DeliveryRoute;
import repositories.FileManagementRepository;
import repositories.FileManagementRepositoryImpl;
import usecases.delivery.DeliveryService;
import usecases.delivery.DeliveryServiceImpl;
import usecases.instruction.InstructionService;
import usecases.instruction.InstructionServiceImpl;

import java.util.List;


public class DeliveryDIModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(InstructionService.class)
                .annotatedWith(Names.named("InstructionService"))
                .to(InstructionServiceImpl.class);

        bind(DeliveryService.class)
                .annotatedWith(Names.named("DeliveryService"))
                .to(DeliveryServiceImpl.class);

        bind(FileManagementRepository.class)
                .annotatedWith(Names.named("FileManagementService"))
                .to(FileManagementRepositoryImpl.class);

        bind(new TypeLiteral<ExpensiveInteractor<Integer, List<DeliveryRoute>>>() {
        }).to(ReadFileInteractor.class);

        bind(new TypeLiteral<Interactor<List<String>, List<String>>>() {
        }).to(WriteFileInteractor.class);

        bind(new TypeLiteral<Interactor<Delivery, Delivery>>() {
        }).to(DeliveryInteractor.class);
    }
}
