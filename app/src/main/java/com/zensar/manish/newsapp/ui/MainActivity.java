package com.zensar.manish.newsapp.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.zensar.manish.newsapp.BuildConfig;
import com.zensar.manish.newsapp.R;
import com.zensar.manish.newsapp.databinding.ActivityMainBinding;
import com.zensar.manish.newsapp.ui.headlines.HeadlinesFragment;
import com.zensar.manish.newsapp.ui.news.OptionsBottomSheet;
import com.zensar.manish.newsapp.ui.sources.SourceFragment;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity implements OptionsBottomSheet.OptionsBottomSheetListener {
    private final FragmentManager fragmentManager = getSupportFragmentManager();
    private ActivityMainBinding binding;
    private HeadlinesFragment headlinesFragment;
    private SourceFragment sourceFragment;
    private FirebaseAnalytics mFirebaseAnalytics;
    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Bundle bundle = new Bundle();
            switch (item.getItemId()) {
                case R.id.navigation_headlines:
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, headlinesFragment)
                            .commit();
                    bundle.putString(
                            FirebaseAnalytics.Param.ITEM_CATEGORY,
                            getString(R.string.title_headlines)
                    );
                    return true;

                case R.id.navigation_sources:
                    if (sourceFragment == null) {
                        sourceFragment = SourceFragment.newInstance();
                    }
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, sourceFragment)
                            .commit();
                    bundle.putString(
                            FirebaseAnalytics.Param.ITEM_CATEGORY,
                            getString(R.string.title_sources)
                    );
                    return true;
            }
            mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
            return false;
        }
    };
    private Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        // Bind data using DataBinding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        if (savedInstanceState == null) {
            // Add a default fragment
            headlinesFragment = HeadlinesFragment.newInstance();
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container, headlinesFragment)
                    .commit();
        }

        setupToolbar();
    }

    private void setupToolbar() {
        setSupportActionBar(binding.toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.app_name));
            //Remove trailing space from toolbar
            binding.toolbar.setContentInsetsAbsolute(10, 10);
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.action_menu, menu);
//        return true;
//        //return super.onCreateOptionsMenu(menu);
//    }

    @Override
    public void onSaveToggle(String text) {
        if (snackbar == null) {
            snackbar = Snackbar.make(binding.coordinator, "Hello", Snackbar.LENGTH_SHORT);
            final CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) snackbar.getView().getLayoutParams();
            params.setMargins(
                    (int) getResources().getDimension(R.dimen.snackbar_margin_vertical),
                    0,
                    (int) getResources().getDimension(R.dimen.snackbar_margin_vertical),
                    (int) getResources().getDimension(R.dimen.snackbar_margin_horizontal)
            );
            snackbar.getView().setLayoutParams(params);
            snackbar.getView().setPadding(
                    (int) getResources().getDimension(R.dimen.snackbar_padding),
                    (int) getResources().getDimension(R.dimen.snackbar_padding),
                    (int) getResources().getDimension(R.dimen.snackbar_padding),
                    (int) getResources().getDimension(R.dimen.snackbar_padding)
            );
        }
        if (snackbar.isShown()) {
            snackbar.dismiss();
        }
        snackbar.setText(text);
        snackbar.show();
    }
}
