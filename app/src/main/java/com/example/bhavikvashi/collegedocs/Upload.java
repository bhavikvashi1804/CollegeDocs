package com.example.bhavikvashi.collegedocs;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Upload extends AppCompatActivity {

    String selectedYear,selectedSem,selectedSubject,filename;
    ProgressDialog pd;
    Uri pdfUri;
    TextView checkfilenmame;

    FirebaseStorage storage;//used to upload file
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        Spinner yearSpinner = (Spinner) findViewById(R.id.upload_xml_selectyear);
        final Spinner semSpinner = (Spinner) findViewById(R.id.upload_xml_selectsem);
        final Spinner subjectSpinner=(Spinner)findViewById(R.id.upload_xml_selectsubject);
        final Button upload=(Button)findViewById(R.id.upload_xml_upload);
        final Button select=(Button)findViewById(R.id.upload_xml_selectfile);


        yearSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedYear=parent.getItemAtPosition(position).toString();
                if(selectedYear.equals("1st Year"))
                {
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(Upload.this,
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
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(Upload.this,
                            R.array.array_2year_sem, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    semSpinner.setAdapter(adapter);
                    semSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            selectedSem=parent.getItemAtPosition(position).toString();
                            if(selectedSem.equals("SEM III"))
                            {
                                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(Upload.this,
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
                                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(Upload.this,
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
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(Upload.this,
                            R.array.array_3year_sem, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    semSpinner.setAdapter(adapter);
                    semSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            selectedSem=parent.getItemAtPosition(position).toString();

                            if(selectedSem.equals("SEM V"))
                            {
                                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(Upload.this,
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
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(Upload.this,
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
                if (ContextCompat.checkSelfPermission(Upload.this, android.Manifest.permission.READ_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED)
                {
                    selectPDF();
                }
                else {
                    ActivityCompat.requestPermissions(Upload.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},10);
                }
            }
        });

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Write a message to the database
                EditText et1=(EditText)findViewById(R.id.upload_xml_filename);
                Date cDate = new Date();
                String fDate = new SimpleDateFormat("yyyy-MM-dd").format(cDate);
                filename=et1.getText().toString()+":"+fDate;
                if(pdfUri!=null && filename!=null )
                {

                    FileUploadInfo f1=new FileUploadInfo(selectedYear,selectedSem,selectedSubject,filename,null);
                    UploadFile(pdfUri,f1);
                }
                else{
                    Toast.makeText(Upload.this,"File is not selected",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==10 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
        {
            selectPDF();
        }
        else{
            Toast.makeText(Upload.this,"Permission is not granted",Toast.LENGTH_SHORT).show();
        }

    }

    private void selectPDF()
    {
        Intent i1=new Intent();
        i1.setType("application/pdf");
        i1.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(i1,86);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==86 && resultCode==RESULT_OK && data!=null)
        {
            pdfUri=data.getData();
            checkfilenmame=findViewById(R.id.upload_xml_check);
            checkfilenmame.setText("File sucessfully selected:"+data.getData().getLastPathSegment());
            Toast.makeText(Upload.this,"File selected successfully",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(Upload.this,"No file is selected",Toast.LENGTH_SHORT).show();
        }
    }

    private void UploadFile(Uri uri, FileUploadInfo f1)
    {
        pd=new ProgressDialog(Upload.this);
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.setTitle("Uploading File");
        pd.setProgress(0);
        pd.show();

        final FileUploadInfo currentOb=f1;
        final String uploadFileName=currentOb.getType()+".pdf";
        Log.d("Upload","My upload file name is "+uploadFileName);
        final StorageReference r=storage.getInstance().getReference(); //returns path of firebase storage(actually root path)
        r.child("Upload").child(currentOb.getYear()).child(currentOb.getSem()).child(currentOb.getSubject()).child(uploadFileName).putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                r.child("Upload").child(currentOb.getYear()).child(currentOb.getSem()).child(currentOb.getSubject()).child(uploadFileName).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                       currentOb.setUrl(uri.toString());
                       updateDataBase(currentOb);
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Upload.this,"File is not sucessfully uploaded",Toast.LENGTH_SHORT).show();
            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                int currentProgress=(int)(100*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                if(currentProgress!=100)
                {
                    pd.setProgress(currentProgress);
                }
                else
                {
                    pd.dismiss();
                }
            }
        });

    }

    private void updateDataBase(FileUploadInfo currentOb) {
        DatabaseReference r=database.getInstance().getReference();
        r.child("FileInformation").child(selectedYear).child(selectedSem).child(selectedSubject).child(filename).setValue(currentOb.getUrl()).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                    Toast.makeText(Upload.this,"Database Updated",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Upload.this,"Database entry is not created",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
