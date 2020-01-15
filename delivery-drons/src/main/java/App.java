import Interactor.base.ExpensiveInteractor;
import Interactor.base.Interactor;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import dic.DeliveryDIModule;
import io.reactivex.BackpressureStrategy;
import models.Delivery;
import models.DeliveryRoute;
import models.Drone;

import java.io.FileNotFoundException;
import java.util.List;

public class App {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new DeliveryDIModule());

        ExpensiveInteractor<Integer, List<DeliveryRoute>> readFileInteractor = injector.
                getInstance(Key.get(new TypeLiteral<ExpensiveInteractor<
                        Integer, List<DeliveryRoute>>>() {
                }));

        Interactor<List<String>, List<String>> writeFileInteractor = injector.
                getInstance(Key.get(new TypeLiteral<Interactor<List<String>, List<String>>>() {
                }));

        Interactor<Delivery, Delivery> deliveryInteractor = injector.
                getInstance(Key.get(new TypeLiteral<Interactor<Delivery, Delivery>>() {
                }));

        readFileInteractor.execute(10)
                .flatMap(routes -> {
                    if (routes.size() == 0) throw new FileNotFoundException("Could not find this file");
                    Drone drone = new Drone(String.valueOf(Math.random()), 10);
                    Delivery delivery = new Delivery(routes, drone);
                    return deliveryInteractor.execute(delivery).toFlowable(BackpressureStrategy.BUFFER);
                })
                .flatMap(delivery -> writeFileInteractor.execute(delivery.getDeliveryReport()).toFlowable(BackpressureStrategy.BUFFER))
                .sequential()
                .blockingSubscribe(report -> report.forEach(System.out::println), error -> System.out.println("Could not find this file"));
    }

}
