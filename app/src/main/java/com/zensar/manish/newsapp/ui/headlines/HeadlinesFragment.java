package com.zensar.manish.newsapp.ui.headlines;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zensar.manish.newsapp.R;
import com.zensar.manish.newsapp.databinding.FragmentHeadlinesBinding;
import com.zensar.manish.newsapp.network.NewsApi;
import com.zensar.manish.newsapp.utils.preference.PreferenceConfiguration;

public class HeadlinesFragment extends Fragment {
    private final String[] categories = {
            NewsApi.Category.general.name(),
            NewsApi.Category.business.name(),
            NewsApi.Category.sports.name(),
            NewsApi.Category.health.name(),
            NewsApi.Category.entertainment.name(),
            NewsApi.Category.technology.name(),
            NewsApi.Category.science.name(),
    };
    private final int[] categoryIcons = {
            R.drawable.ic_headlines,
            R.drawable.nav_business,
            R.drawable.nav_sports,
            R.drawable.nav_health,
            R.drawable.nav_entertainment,
            R.drawable.nav_tech,
            R.drawable.nav_science,

    };

//    private final String[] country = {
//            NewsApi.Country.united_state.name(),
//            NewsApi.Country.canada.name(),
//    };

    private String countryCode;
    private FragmentHeadlinesBinding binding;

    public HeadlinesFragment() {
        // Required empty public constructor
    }

    public static HeadlinesFragment newInstance() {
        return new HeadlinesFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //setHasOptionsMenu(true);
        this.binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_headlines, container, false);


        ViewCompat.setElevation(binding.tablayoutHeadlines, getResources().getDimension(R.dimen.tab_layout_elevation));

        if (getActivity() != null) {
            countryCode = PreferenceConfiguration.getCountryCodePref(getActivity(), "");
            ViewPagerAdapter viewPager = new ViewPagerAdapter(getChildFragmentManager(), categories, countryCode);
            binding.viewpagerHeadlines.setAdapter(viewPager);
            binding.tablayoutHeadlines.setupWithViewPager(binding.viewpagerHeadlines);
            setupTabIcons();
        }
        return this.binding.getRoot();
    }

    private void setupTabIcons() {
        TabLayout.Tab tab;
        for (int i = 0; i < categories.length; i++) {
            tab = binding.tablayoutHeadlines.getTabAt(i);
            if (tab != null) {
                tab.setIcon(categoryIcons[i]).setText(categories[i]);
            }
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        //super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.action_menu, menu);
    }

    public void reLoadFragment(Fragment fragment)
    {
        //Log.i(LogGeneratorHelper.INFO_TAG, "reloading fragment");
        Fragment currentFragment = fragment;
        if (currentFragment instanceof HeadlinesFragment) {
        FragmentTransaction fragTransaction =   (getActivity()).getSupportFragmentManager().beginTransaction();
        fragTransaction.detach(currentFragment);
        fragTransaction.attach(currentFragment);
        fragTransaction.commit();
        //Log.i(LogGeneratorHelper.INFO_TAG, "reloading fragment finish");
    }
    //else Log.i(LogGeneratorHelper.INFO_TAG, "fragment reloading failed");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.us_lang:
                // do stuff
                Toast.makeText(getActivity(), "US Lang", Toast.LENGTH_SHORT).show();
                //countryCode = "us";
                PreferenceConfiguration.setCountryCodePref(getActivity(), "us");

//                FragmentTransaction ft = getFragmentManager().beginTransaction();
//                ft.detach(this).attach(this).commitAllowingStateLoss();
//
//                //reLoadFragment(HeadlinesFragment.this);
//                Bundle bundle = new Bundle();
//
//                HeadlinesFragment headlinesFragment = HeadlinesFragment.newInstance();
//                getActivity().getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.fragment_container, headlinesFragment)
//                        .commit();
//                bundle.putString(
//                        FirebaseAnalytics.Param.ITEM_CATEGORY,
//                        getString(R.string.title_headlines)
//                );

                //FragmentTransaction ft = getFragmentManager().beginTransaction();
                //ft.detach(this).attach(this).commit();

                //reLoadFragment(HeadlinesFragment.this);

                Intent intent = getActivity().getIntent();
                getActivity().finish();
                startActivity(intent);

                return true;

            case R.id.ca_lang:
                // do more stuff
                Toast.makeText(getActivity(), "CA Lang", Toast.LENGTH_SHORT).show();
                //countryCode = "ca";
                PreferenceConfiguration.setCountryCodePref(getActivity(), "ca");

                Intent intent1 = getActivity().getIntent();
                getActivity().finish();
                startActivity(intent1);

                //FragmentTransaction ft1 = getFragmentManager().beginTransaction();
                //ft1.detach(this).attach(this).commit();

                //reLoadFragment(HeadlinesFragment.this);

                return true;
        }

        return false;
    }
}
