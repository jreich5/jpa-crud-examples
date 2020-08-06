package com.codeup.jpacrudexamples.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ads")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // to allow a single entity to be returned in the JSON
public class Ad {

    // =========== PROPERTIES

    // properties that will become columns in the table

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50, nullable = false, unique = true)
    private String title;

    @Column(columnDefinition = "TEXT NOT NULL")
    private String description;

    // relationship properties

    @OneToMany(mappedBy = "ad", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Comment> comments;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }) // all is not used to prevent deletion of tags when deleting an ad
    @JoinTable(
            name = "ad_tag",
            joinColumns = @JoinColumn(name = "ad_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    @JsonManagedReference
    private List<Tag> tags = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ad_details_id", referencedColumnName = "id")
    @JsonManagedReference
    private AdDetails adDetails;

    // =========== CONSTRUCTORS

    public Ad() {
    }

    public Ad(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Ad(String title) {
        this.title = title;
    }

    // =========== HELPER METHODS

    public void addTag(Tag tag) {
        tags.add(tag); // add tag to list of tags for this ad
        tag.getAds().add(this); // add this ad to this tag
    }

    public void removeTag(Tag tag) {
        tags.remove(tag); // remove tag from list of tags for this ad
        tag.getAds().remove(this); // remove this ad from the tag list of ads
    }


    // =========== GETTERS AND SETTERS

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public AdDetails getAdDetails() {
        return adDetails;
    }

    public void setAdDetails(AdDetails adDetails) {
        this.adDetails = adDetails;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

}
