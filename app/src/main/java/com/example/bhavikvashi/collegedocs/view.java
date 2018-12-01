package com.example.bhavikvashi.collegedocs;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class view extends AppCompatActivity {
    private ItemAdapter mAdapter;
    private TextView mEmptyStateTextView;
    private ListView FileListView;
    private ArrayList<FileUploadInfo> myArrayList;
    private ItemAdapter i1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        myArrayList=new ArrayList<>();


        FileListView=(ListView)findViewById(R.id.viewlist1);
        i1=new ItemAdapter(this,myArrayList);
        FileListView.setAdapter(i1);

        Intent i=getIntent();
        String msg[]=i.getStringArrayExtra("Selected");

        DatabaseReference reference=FirebaseDatabase.getInstance().getReference();
        reference.child("FileInformation").child(msg[0]).child(msg[1]).child(msg[2]).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                //actually calls for each item in database
                String filename=dataSnapshot.getKey();//return file name
                String url=dataSnapshot.getValue(String.class);//return url
                if(filename==null)
                {
                    Toast.makeText(getApplicationContext(),"No files",Toast.LENGTH_SHORT).show();
                }
                myArrayList.add(new FileUploadInfo("3rd Year","SEM IV","ADA",filename,url));
                i1.notifyDataSetChanged();
            }
            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }
            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
            }
            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}

