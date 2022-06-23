package com.zensar.manish.newsapp.models;

import java.util.ArrayList;

public class SourceResponseWrapper {
    private final String status;
    private final ArrayList<Source> sources;

    public SourceResponseWrapper(String status, ArrayList<Source> sources) {
        this.status = status;
        this.sources = sources;
    }

    public String getStatus() {
        return status;
    }

    public ArrayList<Source> getSources() {
        return sources;
    }
}
