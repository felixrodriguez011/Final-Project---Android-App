package isel.pdm.FxDatabase.ui.activity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import isel.pdm.FxDatabase.R;
import isel.pdm.FxDatabase.ui.activity.base.ToolbarActivity;

/**
 * Activity to display the app credits
 */
public class AboutActivity extends ToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.enableBackButton();
        toolbar.setTitle(R.string.about);

    }

    @Override
    protected int getToolbarLayout() {
        return R.layout.activity_about;
    }
}
