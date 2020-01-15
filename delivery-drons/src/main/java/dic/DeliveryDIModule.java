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
import utils.RoutesMapper;

import java.util.List;


public class DeliveryDIModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(RoutesMapper.class)
                .annotatedWith(Names.named("RoutesMapper"))
                .to(RoutesMapper.class);

        bind(FileManagementRepository.class)
                .annotatedWith(Names.named("FileManagementService"))
                .to(FileManagementRepositoryImpl.class);

        bind(new TypeLiteral<ExpensiveInteractor<Integer, Delivery>>() {
        }).to(ReadFileInteractor.class);

        bind(new TypeLiteral<Interactor<Delivery, List<String>>>() {
        }).to(WriteFileInteractor.class);

        bind(new TypeLiteral<Interactor<Delivery, Delivery>>() {
        }).to(DeliveryInteractor.class);
    }
}
