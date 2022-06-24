package com.zensar.manish.newsapp;

import com.zensar.manish.newsapp.network.NewsApi;
import com.zensar.manish.newsapp.network.NewsApiClient;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class NewsApiClientTest {

    private static NewsApi sNewsApi = Mockito.mock(NewsApi.class);

    @Mock
    private static NewsApiClient sInstance = new NewsApiClient();

    @Test
    public void getHeadlines() {

    }
}
