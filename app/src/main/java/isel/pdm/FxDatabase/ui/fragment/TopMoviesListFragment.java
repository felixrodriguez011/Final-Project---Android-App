package isel.pdm.FxDatabase.ui.fragment;

import isel.pdm.FxDatabase.ui.fragment.common.MovieListableFragment;
import isel.pdm.FxDatabase.ui.presenter.TopMoviesListPresenter;
import isel.pdm.FxDatabase.ui.presenter.base.IPresenter;

/**
 * Top movies fragment
 */
public class TopMoviesListFragment extends MovieListableFragment {

    @Override
    protected IPresenter createPresenter() {
        return new TopMoviesListPresenter(this);
    }
}
