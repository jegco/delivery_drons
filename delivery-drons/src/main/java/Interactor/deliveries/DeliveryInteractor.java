package Interactor.deliveries;

import Interactor.base.ObservableInteractor;
import io.reactivex.Observable;
import models.Delivery;

public class DeliveryInteractor extends ObservableInteractor<Delivery, Delivery> {

    public DeliveryInteractor() {
    }

    @Override
    protected Observable<Delivery> buildUseCase(Delivery delivery) {
        return Observable.just(delivery.go());
    }
}
