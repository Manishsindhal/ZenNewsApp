package com.zensar.manish.newsapp;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import android.support.annotation.NonNull;

import com.zensar.manish.newsapp.data.NewsRepository;
import com.zensar.manish.newsapp.models.Article;
import com.zensar.manish.newsapp.models.Specification;
import com.zensar.manish.newsapp.network.NewsApi;
import com.zensar.manish.newsapp.network.NewsApiClient;
import com.zensar.manish.newsapp.ui.news.NewsViewModel;

import org.jetbrains.annotations.NotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class NewsViewModelTest {

    @Mock
    private NewsRepository newsRepository;

    @Mock
    Specification specs;

    public NewsViewModelTest() {
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        specs.setCategory(NewsApi.Category.business);
        specs.setCountry("us");
    }

    @Test
    public void testApiFetchDataSuccess() {
        newsRepository.getHeadlines(specs);
    }
}
