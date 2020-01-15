package Interactor.base;

import io.reactivex.parallel.ParallelFlowable;

public interface ExpensiveInteractor<Params, Response> {
    ParallelFlowable<Response> execute(Params params);
}
