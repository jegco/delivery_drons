package Interactor.base;

import io.reactivex.Observable;

public interface Interactor<Params, Response> {
    Observable<Response> execute(Params params);
}
