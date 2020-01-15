package Interactor.files;

import Interactor.base.FlowableInteractor;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import models.DeliveryRoute;
import repositories.FileManagementRepository;

import java.io.File;
import java.util.List;
import java.util.Objects;

public class ReadFileInteractor extends FlowableInteractor<Integer, List<DeliveryRoute>> {

    private FileManagementRepository fileManagementRepository;

    @Inject
    public ReadFileInteractor(@Named("FileManagementService") FileManagementRepository fileManagementRepository) {
        this.fileManagementRepository = fileManagementRepository;
    }

    @Override
    protected Flowable<List<DeliveryRoute>> buildUseCase(Integer numberOfFiles) {
        File dir = new File("../input-files/");
        return Observable.fromArray(Objects.requireNonNull(dir.listFiles((d, name) -> name.endsWith(".txt"))))
                .take(numberOfFiles)
                .toFlowable(BackpressureStrategy.BUFFER).flatMap(fileName ->
                        Flowable
                                .just(fileManagementRepository.readFile(fileName)));
    }
}
