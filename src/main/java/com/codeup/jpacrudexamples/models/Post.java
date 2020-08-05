package com.codeup.jpacrudexamples.models;

public class Post {
    private String title;
    private String body;
    private long id;

    public Post(){}

    public Post(long id, String title, String body){
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public String getTitle(){
        return title;
    }

    public String getBody(){
        return body;
    }

    public void setTitle(String newTitle){
        this.title = newTitle;
    }

    public void setBody(String newBody){
        this.body = newBody;
    }
}
