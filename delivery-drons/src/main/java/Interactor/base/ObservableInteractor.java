package Interactor.base;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public abstract class ObservableInteractor<Params, Response> implements Interactor<Params, Response> {
    @Override
    public Observable<Response> execute(Params params) {
        return buildUseCase(params)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single());
    }

    protected abstract Observable<Response> buildUseCase(Params params);
}
