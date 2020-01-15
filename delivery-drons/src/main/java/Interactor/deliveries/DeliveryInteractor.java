package Interactor.deliveries;

import Interactor.base.ObservableInteractor;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import io.reactivex.Observable;
import models.Delivery;
import usecases.delivery.DeliveryService;

public class DeliveryInteractor extends ObservableInteractor<Delivery, Delivery> {

    private DeliveryService deliveryService;

    @Inject
    public DeliveryInteractor(@Named("DeliveryService") DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @Override
    protected Observable<Delivery> buildUseCase(Delivery delivery) {
        return Observable.just(deliveryService.deliverOrder(delivery));
    }
}
