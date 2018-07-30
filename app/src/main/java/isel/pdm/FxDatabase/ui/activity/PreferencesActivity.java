package isel.pdm.FxDatabase.ui.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import isel.pdm.FxDatabase.R;
import isel.pdm.FxDatabase.FxDatabaseApplication;
import isel.pdm.FxDatabase.ui.activity.base.ToolbarActivity;
import isel.pdm.FxDatabase.ui.fragment.PreferencesFragment;

/**
 * Class used to store shared preferences of some details of the application
 * Uses a PreferencesFragment
 */
public class PreferencesActivity extends ToolbarActivity implements SharedPreferences.OnSharedPreferenceChangeListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar.setTitle(R.string.preferences);
        this.enableBackButton();

        PreferenceManager.getDefaultSharedPreferences(this).registerOnSharedPreferenceChangeListener(this);

        getFragmentManager().beginTransaction()
                            .replace(R.id.content, new PreferencesFragment()).commit();
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if(key.equals(getResources().getString(R.string.soon_periodicity))){
            int days = Integer.parseInt(sharedPreferences.getString(key, "7"));
            ((FxDatabaseApplication)getApplication()).refreshTheatersAlarm(days);
        }
    }
}
