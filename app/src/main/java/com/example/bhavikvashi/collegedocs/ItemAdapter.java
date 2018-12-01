package com.example.bhavikvashi.collegedocs;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

import static android.support.v4.content.ContextCompat.startActivity;

public class ItemAdapter extends ArrayAdapter<FileUploadInfo>
{
    public ItemAdapter(Context context, ArrayList<FileUploadInfo> arrayList)
    {
        super(context,0,arrayList);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        final FileUploadInfo n1=getItem(position);
        final String url=n1.getUrl();
        if(convertView==null)
        {
            convertView=LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        TextView name=(TextView)convertView.findViewById(R.id.nameoffile);
        name.setText(n1.getType());
        ImageButton view=(ImageButton)convertView.findViewById(R.id.button_v);
        view.setVisibility(View.INVISIBLE);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        ImageButton download=(ImageButton)convertView.findViewById(R.id.button_d);
        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent();
                i1.setType(Intent.ACTION_VIEW);
                i1.setData(Uri.parse(url));
                startActivity(getContext(),i1,null);
            }
        });
        return convertView;
    }
}
