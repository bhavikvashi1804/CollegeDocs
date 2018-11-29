package com.example.bhavikvashi.collegedocs;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ty_1 extends AppCompatActivity implements android.app.LoaderManager.LoaderCallbacks<List<Files>> {

    private  ItemAdapter mAdapter;
    private static final String request_url="https://script.googleusercontent.com/macros/echo?user_content_key=SqCStiS3GmwZbbjBnF8tfmHApnV-bx-WRhsoxtB78UlWPLC0b9T22e3swrSa_74xkQ7tStIfFnXcABskIScxb_zCpYN70gBcOJmA1Yb3SEsKFZqtv3DaNYcMrmhZHmUMWojr9NvTBuBLhyHCd5hHa9hDv5MnIxZmFsiCBqST18gMZdwIyvrfigibpwzjN-493ZEnYU5NGQjHXMjCMUaz63UNrcKCeA_F9uhCjXU_FHjZTDavebkOaraER3luDymBtbkE8aV8bHUVMSyTlysjYKpRrJxMCezbwqJbeTowOR_fVIgxkfofiQ&lib=MNjJEA1icQR1Hcc9bHxf0tKJFgJfzwc-W";
    private static final int LOADER_ID = 1;
    private TextView mEmptyFileTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ty_1);

        ListView ob1=(ListView)findViewById(R.id.list5);
        mAdapter = new ItemAdapter(this, new ArrayList<Files>());
        ob1.setAdapter(mAdapter);

        mEmptyFileTextView = (TextView) findViewById(R.id.emptystate);
        mEmptyFileTextView.setText("Files are Loading");
        ob1.setEmptyView(mEmptyFileTextView);

        ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        if(isConnected)
        {
            android.app.LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(LOADER_ID, null, this);
        }
        else
        {
            View loadingIndicator = findViewById(R.id.loading);
            loadingIndicator.setVisibility(View.GONE);
            mEmptyFileTextView.setText("No internet");
        }
    }

    @Override
    public android.content.Loader<List<Files>> onCreateLoader(int i, Bundle bundle) {
        // Create a new loader for the given URL
        return new FileLoader(this, request_url);
    }

    @Override
    public void onLoadFinished(android.content.Loader<List<Files>> loader, List<Files> earthquakes) {
        // Clear the adapter of previous earthquake data
        ProgressBar p1=(ProgressBar)findViewById(R.id.loading);
        p1.setVisibility(View.INVISIBLE);
        mAdapter.clear();

        // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (earthquakes != null && !earthquakes.isEmpty()) {
            mAdapter.addAll(earthquakes);
        }
        mEmptyFileTextView.setText("No Files!");
    }
    @Override
    public void onLoaderReset(android.content.Loader<List<Files>> loader) {
        mAdapter.clear();

    }


}
