package com.example.bhavikvashi.collegedocs;

public class Files
{
    String subject,name,link;

    Files(String w,String x,String y)
    {
        subject=w;
        name=x;
        link=y;
    }

    public String getName() {
        return name;
    }
    public String getLink()
    {
        return link;
    }

    public String getSubject() {
        return subject;
    }
}
