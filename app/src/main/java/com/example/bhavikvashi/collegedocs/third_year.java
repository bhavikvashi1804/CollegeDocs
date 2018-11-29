package com.example.bhavikvashi.collegedocs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class third_year extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_year);

        Button b1=(findViewById(R.id.sem5));
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(third_year.this,ty_1.class);
                startActivity(i1);
            }
        }
        );
        Button b2=(findViewById(R.id.sem6));
        b1.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      Intent i1=new Intent(third_year.this,ty_1.class);
                                      startActivity(i1);
                                  }
                              }
        );
    }
}
