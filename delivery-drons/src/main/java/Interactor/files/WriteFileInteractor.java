package Interactor.files;

import Interactor.base.ObservableInteractor;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import io.reactivex.Observable;
import repositories.FileManagementRepository;

import java.util.List;

public class WriteFileInteractor extends ObservableInteractor<List<String>, List<String>> {

    private FileManagementRepository fileManagementRepository;
    private int count = 0;

    @Inject
    public WriteFileInteractor(@Named("FileManagementService") FileManagementRepository fileManagementRepository) {
        this.fileManagementRepository = fileManagementRepository;
    }

    @Override
    protected Observable<List<String>> buildUseCase(List<String> report) {
        fileManagementRepository.writeFile(report, count);
        count++;
        return Observable.just(report);
    }
}
