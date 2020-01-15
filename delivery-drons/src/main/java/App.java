import Interactor.base.ExpensiveInteractor;
import Interactor.base.Interactor;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import dic.DeliveryDIModule;
import io.reactivex.BackpressureStrategy;
import models.Delivery;

import java.util.List;

public class App {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new DeliveryDIModule());

        ExpensiveInteractor<Integer, Delivery> readFileInteractor = injector.
                getInstance(Key.get(new TypeLiteral<ExpensiveInteractor<Integer, Delivery>>() {
                }));

        Interactor<Delivery, List<String>> writeFileInteractor = injector.
                getInstance(Key.get(new TypeLiteral<Interactor<Delivery, List<String>>>() {
                }));

        Interactor<Delivery, Delivery> deliveryInteractor = injector.
                getInstance(Key.get(new TypeLiteral<Interactor<Delivery, Delivery>>() {
                }));

        readFileInteractor.execute(20)
                .flatMap(delivery -> deliveryInteractor.execute(delivery).toFlowable(BackpressureStrategy.BUFFER))
                .flatMap(delivery -> writeFileInteractor.execute(delivery).toFlowable(BackpressureStrategy.BUFFER))
                .sequential()
                .blockingSubscribe(report -> report.forEach(System.out::println),
                        error -> System.out.println("Could not find this file"));
    }

}
