package isel.pdm.FxDatabase.ui.fragment;

import isel.pdm.FxDatabase.ui.fragment.common.MovieListableFragment;
import isel.pdm.FxDatabase.ui.presenter.InTheatersMoviesListPresenter;
import isel.pdm.FxDatabase.ui.presenter.base.IPresenter;

/**
 * Fragment representing the movies list in theaters
 */
public class InTheatersMoviesListFragment extends MovieListableFragment {

    @Override
    protected IPresenter createPresenter() {
        return new InTheatersMoviesListPresenter(this);
    }
}
