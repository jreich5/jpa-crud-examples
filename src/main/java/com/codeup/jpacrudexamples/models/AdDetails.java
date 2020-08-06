package com.codeup.jpacrudexamples.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "adDetails")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // to allow a single entity to be returned in the JSON
public class AdDetails {

    // =========== PROPERTIES

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String extraInfo;

    @OneToOne(mappedBy = "adDetails")
    @JsonBackReference
    private Ad ad;

    // =========== CONSTRUCTORS

    public AdDetails() {
    }

    public AdDetails(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    // =========== GETTERS AND SETTERS

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public Ad getAd() {
        return ad;
    }

    public void setAd(Ad ad) {
        this.ad = ad;
    }
}
