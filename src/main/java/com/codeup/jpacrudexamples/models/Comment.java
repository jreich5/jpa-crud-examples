package com.codeup.jpacrudexamples.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String content;

    @ManyToOne
    @JsonBackReference
    private Ad ad;

    public Comment() {
    }

    public Comment(String content) {
        this.content = content;
    }

    public Comment(String content, Ad ad) {
        this.content = content;
        this.ad = ad;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Ad getAd() {
        return ad;
    }

    public void setAd(Ad ad) {
        this.ad = ad;
    }
}
