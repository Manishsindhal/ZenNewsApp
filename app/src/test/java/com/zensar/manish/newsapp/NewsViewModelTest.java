package com.zensar.manish.newsapp;

import android.app.Application;
import android.arch.lifecycle.Observer;

import com.zensar.manish.newsapp.data.NewsRepository;
import com.zensar.manish.newsapp.models.Article;
import com.zensar.manish.newsapp.models.ArticleResponseWrapper;
import com.zensar.manish.newsapp.models.ArticleSource;
import com.zensar.manish.newsapp.models.Specification;
import com.zensar.manish.newsapp.network.NewsApiClient;
import com.zensar.manish.newsapp.ui.news.NewsFragment;
import com.zensar.manish.newsapp.ui.news.NewsViewModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import javax.net.ssl.HttpsURLConnection;

import retrofit2.Response;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NewsViewModelTest {

    @Mock
    NewsRepository newsRepository;

    @Mock
    NewsApiClient apiClient;

    @Mock
    Application application;

    @Mock
    Specification specs;

    private NewsViewModel viewModel;

    Observer<List<Article>> observer;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        viewModel = new NewsViewModel(application);
        newsRepository = NewsRepository.getInstance(NewsViewModelTest.this.application.getApplicationContext());
        //viewModel.getNewsListState().observeForever(observer);
    }

    @Test
    public void testNull() {
        when(apiClient.getHeadlines(specs)).thenReturn(null);
        assertNotNull(viewModel.getNewsHeadlines(specs));
        assertTrue(viewModel.getNewsHeadlines(specs).hasObservers());
    }

    @Test
    public void testApiFetchDataSuccess() {
        // Mock API response
//        when(apiClient.getHeadlines(specs)).thenReturn(new List<Article>(new Article("1",
//                "Weizhen Tan",
//                "Dan Yergin explains - CNBC",
//                "Oil prices have been dropping",
//                Timestamp.valueOf("2022-06-24T04:53:51Z"),
//                "https://image.cnbcfm.com/api/v1/image/107070685-1654229939117-gettyimages-1240441119-CALIFORNIA_OIL.jpeg?v=1654229622&w=1920&h=1080",
//                "",
//                "Energy expert Dan Yergin said there are two reasons why ")));
        viewModel.getNewsHeadlines(specs);
    }
}
