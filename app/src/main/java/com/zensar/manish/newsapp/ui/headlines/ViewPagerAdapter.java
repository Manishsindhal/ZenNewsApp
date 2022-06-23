package com.zensar.manish.newsapp.ui.headlines;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.zensar.manish.newsapp.network.NewsApi;
import com.zensar.manish.newsapp.ui.news.NewsFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private final NewsFragment[] newsFragments;


    public ViewPagerAdapter(FragmentManager fm, String[] categories, String country) {
        super(fm);
        newsFragments = new NewsFragment[categories.length];
        for (int i = 0; i < categories.length; i++) {
            newsFragments[i] = NewsFragment.newInstance(NewsApi.Category.valueOf(categories[i]), country);
        }
    }

    @Override
    public Fragment getItem(int i) {
        return newsFragments[i];
    }

    @Override
    public int getCount() {
        return newsFragments == null ? 0 : newsFragments.length;
    }
}
