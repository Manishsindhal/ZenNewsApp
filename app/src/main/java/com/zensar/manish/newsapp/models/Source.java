package com.zensar.manish.newsapp.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Source of news provided
 */
@Entity(tableName = "sources")
public class Source {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private final String id;
    @ColumnInfo(name = "name")
    private final String name;
    @ColumnInfo(name = "description")
    private final String description;
    @ColumnInfo(name = "url")
    private final String url;
    @ColumnInfo(name = "category")
    private final String category;
    @ColumnInfo(name = "language")
    private final String language;
    @ColumnInfo(name = "country")
    private final String country;

    /**
     * @param id          of the news source
     * @param name        display name of news source
     * @param description a description of the news source
     * @param url         URL of the homepage
     * @param category    type of news to expect from this news source, example <b>business</b>
     * @param language    language that this news source writes in, example <b>en</b>
     * @param country     country this news source is based in (and primarily writes about), example <b>us</b>
     */
    public Source(@NonNull String id, String name, String description, String url, String category, String language, String country) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
        this.category = category;
        this.language = language;
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getCategory() {
        return category;
    }

    public String getLanguage() {
        return language;
    }

    public String getCountry() {
        return country;
    }
}
