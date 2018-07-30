package isel.pdm.FxDatabase.ui.fragment;

import isel.pdm.FxDatabase.ui.fragment.common.MovieListableFragment;
import isel.pdm.FxDatabase.ui.presenter.SoonMoviesListPresenter;
import isel.pdm.FxDatabase.ui.presenter.base.IPresenter;

/**
 * Soon movies fragment
 */
public class SoonMoviesListFragment extends MovieListableFragment {

    @Override
    protected IPresenter createPresenter() {
        return new SoonMoviesListPresenter(this);
    }
}
