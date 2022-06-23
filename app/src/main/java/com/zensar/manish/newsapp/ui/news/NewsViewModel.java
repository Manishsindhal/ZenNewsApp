package com.zensar.manish.newsapp.ui.news;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.zensar.manish.newsapp.data.NewsRepository;
import com.zensar.manish.newsapp.models.Article;
import com.zensar.manish.newsapp.models.Specification;

import java.util.List;

public class NewsViewModel extends AndroidViewModel {
    private final NewsRepository newsRepository;

    public NewsViewModel(@NonNull Application application) {
        super(application);
        newsRepository = NewsRepository.getInstance(application.getApplicationContext());
    }

    public LiveData<List<Article>> getNewsHeadlines(Specification specification) {
        return newsRepository.getHeadlines(specification);
    }

//    public LiveData<List<Article>> getAllSaved() {
//        return newsRepository.getSaved();
//    }

//    public LiveData<Boolean> isSaved(int articleId) {
//        return newsRepository.isSaved(articleId);
//    }

//    public void toggleSave(int articleId) {
//        newsRepository.removeSaved(articleId);
//    }
}
