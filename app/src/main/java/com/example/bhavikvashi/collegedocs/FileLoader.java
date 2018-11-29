package com.example.bhavikvashi.collegedocs;

import android.content.AsyncTaskLoader;
import android.content.Context;
import java.util.List;

public class FileLoader extends AsyncTaskLoader<List<Files>> {


    private  final String LOG_TAG =FileLoader.class.getName();

    private String mUrl;


    public FileLoader(Context context, String url)
    {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<Files> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of earthquakes.
        List<Files> ob1 = Utils.fetchEarthquakeData(mUrl);
        return ob1;
    }
}
