package com.example.bhavikvashi.collegedocs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements OnItemSelectedListener {

    private int selectedno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Spinner spinner = (Spinner) findViewById(R.id.spinner_year);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.array_year, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        Button b1=(findViewById(R.id.button_select_year));
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedno==1)
                {
                    Intent i1=new Intent(MainActivity.this,first_year.class);
                    startActivity(i1);
                }
                else if(selectedno==2)
                {
                    Intent i1=new Intent(MainActivity.this,second_year.class);
                    startActivity(i1);
                }
                else if(selectedno==3)
                {
                    Intent i1=new Intent(MainActivity.this,third_year.class);
                    startActivity(i1);
                }
                else if(selectedno==4)
                {
                    Intent i1=new Intent(MainActivity.this,fourth_year.class);
                    startActivity(i1);
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        String text= parent.getItemAtPosition(position).toString();
        if(text.equals("1st Year"))
        {
            selectedno=1;
        }
        else if(text.equals("2nd Year"))
        {
            selectedno=2;
        }
        else if(text.equals("3rd Year"))
        {
            selectedno=3;
        }
        else
        {
            selectedno=4;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
