package Interactor.base;

import io.reactivex.Flowable;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.schedulers.Schedulers;

public abstract class FlowableInteractor<Params, Response> implements ExpensiveInteractor<Params, Response> {
    @Override
    public ParallelFlowable<Response> execute(Params params) {
        return buildUseCase(params)
                .parallel()
                .runOn(Schedulers.io());
    }

    protected abstract Flowable<Response> buildUseCase(Params params);
}
