package isel.pdm.FxDatabase.data.services.lists;

import android.content.Intent;
import android.util.Log;

import java.util.List;

import isel.pdm.FxDatabase.data.exception.FailedGettingDataException;
import isel.pdm.FxDatabase.data.provider.MoviesContract;
import isel.pdm.FxDatabase.data.repository.base.ICloudMovieRepository;
import isel.pdm.FxDatabase.data.repository.base.ILocalMovieRepository;
import isel.pdm.FxDatabase.data.repository.base.MovieRepositoryFactory;
import isel.pdm.FxDatabase.data.services.ListService;
import isel.pdm.FxDatabase.model.Movie;


/**
 * This service is repeated like defined in the preferences
 * and its purpose is to fetch the movies in theaters right now
 * and save it in the local repo
 */
public class TheatersListService extends ListService {

    @Override
    protected void onHandleIntent(Intent intent) {
        if(!canDownload()) return;

        try {
            ICloudMovieRepository cloudRepo = MovieRepositoryFactory.getCloudRepository();
            ILocalMovieRepository localRepo = MovieRepositoryFactory.getLocalRepository(getApplicationContext());
            int page = intent.getIntExtra(PAGE, 1);
            List<Movie> movies = cloudRepo.getTheatersMovies(page);

            localRepo.deleteMovies(MoviesContract.MovieEntry.TYPE_NOW);
            if(localRepo.insertMovies(movies, MoviesContract.MovieEntry.TYPE_NOW) <= 0){
                Log.d(TAG, "onHandleIntent: (Theaters) nothing has been inserted");
            }
        } catch (FailedGettingDataException e) {
            Log.d(TAG, "onHandleIntent: error loading from web");
        }
    }

}
