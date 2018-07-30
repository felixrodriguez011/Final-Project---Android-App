package isel.pdm.FxDatabase.ui.presenter.base;

import isel.pdm.FxDatabase.ui.contract.ILoadDataView;

/**
 * Presenter in a model view presenter (MVP) pattern.
 * Should load data and pass it to the view
 * @param <T>
 */
public abstract class Presenter<T> implements IPresenter {

    protected final String TAG = "PRESENTER_" + getClass().getSimpleName();
    protected ILoadDataView<T> view;

    public Presenter(ILoadDataView<T> view) {
        this.view = view;
    }

    /*
    |--------------------------------------------------------------------------
    | Presenter Lifecycle
    |--------------------------------------------------------------------------
    */
    @Override
    public void onResume() {
    }

    @Override
    public void onPause() {
    }

    @Override
    public void onDestroy() {
        //remove reference, no memory leaks
        this.view = null;
    }
}
