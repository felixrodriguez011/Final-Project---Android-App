package isel.pdm.FxDatabase.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.squareup.picasso.Picasso;

import isel.pdm.FxDatabase.R;
import isel.pdm.FxDatabase.Utils;
import isel.pdm.FxDatabase.model.MovieDetails;
import isel.pdm.FxDatabase.ui.activity.MovieCreditsActivity;
import isel.pdm.FxDatabase.ui.fragment.base.LoadDataFragment;
import isel.pdm.FxDatabase.ui.presenter.MovieDetailsPresenter;
import isel.pdm.FxDatabase.ui.presenter.base.IPresenter;

/**
 * Movie details fragment, shows all the movie details
 */
public class MovieDetailsFragment extends LoadDataFragment<MovieDetails> {

    private MovieDetails movie;
    private MovieDetailsPresenter moviePresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View viewContainer = super.onCreateView(inflater, container, savedInstanceState);

        this.moviePresenter = (MovieDetailsPresenter) this.presenter;

        //ask for the movie
        if(!getArguments().isEmpty() && getArguments().getInt("movie_id") != 0) {
            Log.d(TAG, "onCreateView: we have a movie id!");
            this.moviePresenter.setMovieId(getArguments().getInt("movie_id"));
            this.presenter.execute();
        }

        return viewContainer;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_movie;
    }

    @Override
    public void setData(MovieDetails data) {
        this.showResults();
        this.movie = data;

        //set toolbar title
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(data.getTitle());

        ImageView backdropView = (ImageView) this.mainView.findViewById(R.id.movie_back_drop_path);
        ImageView imageView = (ImageView) this.mainView.findViewById(R.id.movie_cover);
        TextView title = (TextView) this.mainView.findViewById(R.id.movie_title_details);
        TextView genre = (TextView) this.mainView.findViewById(R.id.movie_genre);
        TextView rating = (TextView) this.mainView.findViewById(R.id.movie_rating);
        TextView runtime = (TextView) this.mainView.findViewById(R.id.movie_runtime);
        TextView releaseYear = (TextView) this.mainView.findViewById(R.id.movie_release_date);
        TextView overview = (TextView) this.mainView.findViewById(R.id.movie_overview);
        Button creditsButton = (Button) this.mainView.findViewById(R.id.credits_button);

        Picasso.with(getContext()).load(movie.getBackdrop()).into(backdropView);
        Picasso.with(getContext()).load(movie.getPoster()).into(imageView);
        title.setText(movie.getTitle());
        genre.setText(Utils.createGenreText(movie.getGenres()));
        rating.setText(this.getString(R.string.row_rating, movie.getRating()));
        runtime.setText(Utils.createRuntimeText(movie.getRuntime()));
        releaseYear.setText(this.getString(R.string.row_released, movie.getReleaseDate()));
        overview.setText(movie.getOverview());


        creditsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = MovieCreditsActivity.createIntent(getActivity(), movie.getId(), movie.getTitle());
                startActivity(i);
            }
        });


    }

    @Override
    protected IPresenter createPresenter() {
        return new MovieDetailsPresenter(this);
    }
}
