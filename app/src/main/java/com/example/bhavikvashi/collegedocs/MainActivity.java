package com.example.bhavikvashi.collegedocs;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class MainActivity extends AppCompatActivity   {

    String selectedYear,selectedSem,selectedSubject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Spinner yearSpinner = (Spinner) findViewById(R.id.view_xml_selectyear);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.array_year, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearSpinner.setAdapter(adapter);


        final Spinner semSpinner = (Spinner) findViewById(R.id.view_sem);
        final Spinner subjectSpinner=(Spinner)findViewById(R.id.view_subject);
        final Button select=(Button)findViewById(R.id.selected);

        yearSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedYear=parent.getItemAtPosition(position).toString();
                if(selectedYear.equals("1st Year"))
                {
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(MainActivity.this,
                            R.array.array_1year_sem, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    semSpinner.setAdapter(adapter);

                    semSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            selectedSem=parent.getItemAtPosition(position).toString();
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }
                else if (selectedYear.equals("2nd Year"))
                {
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(MainActivity.this,
                            R.array.array_2year_sem, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    semSpinner.setAdapter(adapter);
                    semSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            selectedSem=parent.getItemAtPosition(position).toString();
                            if(selectedSem.equals("SEM III"))
                            {
                                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(MainActivity.this,
                                        R.array.sem3_subject, android.R.layout.simple_spinner_item);
                                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                subjectSpinner.setAdapter(adapter);
                                subjectSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        selectedSubject=parent.getItemAtPosition(position).toString();
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {

                                    }
                                });

                            }
                            else if(selectedSem.equals("SEM IV"))
                            {
                                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(MainActivity.this,
                                        R.array.sem4_subject, android.R.layout.simple_spinner_item);
                                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                subjectSpinner.setAdapter(adapter);
                                subjectSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        selectedSubject=parent.getItemAtPosition(position).toString();
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {

                                    }
                                });
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                else if(selectedYear.equals("3rd Year"))
                {
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(MainActivity.this,
                            R.array.array_3year_sem, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    semSpinner.setAdapter(adapter);
                    semSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            selectedSem=parent.getItemAtPosition(position).toString();

                            if(selectedSem.equals("SEM V"))
                            {
                                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(MainActivity.this,
                                        R.array.sem5_subject, android.R.layout.simple_spinner_item);
                                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                subjectSpinner.setAdapter(adapter);
                                subjectSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        selectedSubject=parent.getItemAtPosition(position).toString();
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {

                                    }
                                });

                            }
                            else if(selectedSem.equals("SEM VI"))
                            {

                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                else if(selectedYear.equals("4th Year"))
                {
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(MainActivity.this,
                            R.array.array_4year_sem, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    semSpinner.setAdapter(adapter);
                    semSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            selectedSem=parent.getItemAtPosition(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FileUploadInfo f1=new FileUploadInfo(selectedYear,selectedSem,selectedSubject,null,null);
                Intent i1=new Intent(MainActivity.this,view.class);
                i1.putExtra("Selected",new String[]{selectedYear,selectedSem,selectedSubject});
                startActivity(i1);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.add:
                Intent i1=new Intent(MainActivity.this,Upload.class);
                startActivity(i1);
                break;
        }
        return true;
    }

    public  FileUploadInfo getCorresponding(){
        return  new FileUploadInfo(selectedYear,selectedSem,selectedSubject,null,null);
    }
}
