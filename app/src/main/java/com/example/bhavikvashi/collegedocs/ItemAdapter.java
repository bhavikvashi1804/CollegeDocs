package com.example.bhavikvashi.collegedocs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

public class ItemAdapter extends ArrayAdapter<Files>
{
    public ItemAdapter(Context context, ArrayList<Files> arrayList)
    {
        super(context,0,arrayList);

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Files n1=getItem(position);
        if(convertView==null)
        {
            convertView=LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        TextView name=(TextView)convertView.findViewById(R.id.nameoffile);
        TextView subject=(TextView)convertView.findViewById(R.id.subject);
        name.setText(n1.getName());
        subject.setText(n1.getSubject());
        return convertView;
    }
}
