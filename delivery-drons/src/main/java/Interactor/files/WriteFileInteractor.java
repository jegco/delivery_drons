package Interactor.files;

import Interactor.base.ObservableInteractor;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import io.reactivex.Observable;
import models.Delivery;
import repositories.FileManagementRepository;

import java.util.List;

public class WriteFileInteractor extends ObservableInteractor<Delivery, List<String>> {

    private FileManagementRepository fileManagementRepository;

    @Inject
    public WriteFileInteractor(@Named("FileManagementService") FileManagementRepository fileManagementRepository) {
        this.fileManagementRepository = fileManagementRepository;
    }

    @Override
    protected Observable<List<String>> buildUseCase(Delivery delivery) {
        return Observable.create(observableEmitter -> {
            fileManagementRepository.writeFile(delivery);
            observableEmitter.onNext(delivery.getDeliveryReport());
            observableEmitter.onComplete();
        });
    }
}
