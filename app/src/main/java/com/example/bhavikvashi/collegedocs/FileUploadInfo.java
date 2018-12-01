package com.example.bhavikvashi.collegedocs;

import android.net.Uri;

public class FileUploadInfo
{
    String year,sem,subject,type,url;

    FileUploadInfo(String a,String b,String c,String d,String e)
    {
        year=a;
        sem=b;
        subject=c;
        type=d;
        url=e;
    }
    public String getYear()
    {
        return year;
    }

    public String getSubject() {
        return subject;
    }

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    public String getSem() {
        return sem;
    }

    public void setUrl(String a){
        url=a;
    }
}
