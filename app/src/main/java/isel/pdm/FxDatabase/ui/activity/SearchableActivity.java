package isel.pdm.FxDatabase.ui.activity;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import isel.pdm.FxDatabase.R;
import isel.pdm.FxDatabase.ui.activity.base.ToolbarActivity;
import isel.pdm.FxDatabase.ui.fragment.SearchMoviesListFragment;

/**
 * Activity to display the movie search results
 */
public class SearchableActivity extends ToolbarActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        toolbar.setTitle(R.string.search_results_title);
        this.enableBackButton();

        handleIntent(getIntent());
    }

    /**
     * Case this activity is in the stack, a back press to here also works
     * @param intent
     */
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            Log.v(TAG, "Searched: " + query);

            //create the fragment and add it
            SearchMoviesListFragment firstFragment = new SearchMoviesListFragment();
            Bundle b = new Bundle();
            b.putString("query", query);
            firstFragment.setArguments(b);

            getSupportFragmentManager().beginTransaction()
                                       .add(R.id.content, firstFragment).commit();
        }
    }
}
