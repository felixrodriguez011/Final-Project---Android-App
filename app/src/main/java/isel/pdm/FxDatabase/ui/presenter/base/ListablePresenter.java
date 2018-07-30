package isel.pdm.FxDatabase.ui.presenter.base;

import isel.pdm.FxDatabase.ui.contract.ILoadDataView;

/**
 * Class used to //TODO: comentary
 */
public abstract class ListablePresenter<T> extends Presenter<T> {

    public ListablePresenter(ILoadDataView<T> view) {
        super(view);
    }

    public abstract void getMoreData(int page);

    public abstract void refresh();
}
