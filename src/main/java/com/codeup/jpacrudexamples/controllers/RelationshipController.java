package com.codeup.jpacrudexamples.controllers;

import com.codeup.jpacrudexamples.models.Ad;
import com.codeup.jpacrudexamples.models.AdDetails;
import com.codeup.jpacrudexamples.models.Comment;
import com.codeup.jpacrudexamples.models.Tag;
import com.codeup.jpacrudexamples.repositories.AdDetailsRepository;
import com.codeup.jpacrudexamples.repositories.AdRepository;
import com.codeup.jpacrudexamples.repositories.CommentRepository;
import com.codeup.jpacrudexamples.repositories.TagRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * This controller demonstrates various CRUD operations with the relationship types.
 * As a demonstration, certain coding practices should be "taken with a grain of salt."
 * The use of GET requests is used throughout for quick testing of these actions; anything
 * other than viewing data should use the appropriate alternative HTTP method (normally POST
 * when sent from an HTML form). The use of JSON is used for simplicity. These repository CRUD
 * actions could easily be used with server-side views, like with using Thymeleaf. The endpoints
 * are also not to be taken too seriously as they are not meant to represent any standard practice.
 * Finally, in some cases, in order to easily test something new was done, new Date().toString is used.
 */
@Controller
public class RelationshipController {

    // Inject dependencies
    private final AdRepository adsDao;
    private final CommentRepository commentsDao;
    private final TagRepository tagsDao;
    private final AdDetailsRepository detailsDao;

    public RelationshipController(AdRepository adsDao, CommentRepository commentsDao, TagRepository tagsDao, AdDetailsRepository detailsDao) {
        this.adsDao = adsDao;
        this.commentsDao = commentsDao;
        this.tagsDao = tagsDao;
        this.detailsDao = detailsDao;
    }

    // ======================= READ EXAMPLES

    // get all ads
//    @GetMapping("/rel/ads")
//    @ResponseBody
//    private List<Ad> getAds() {
//
//    }

    // get all comments for an ad
//    @GetMapping("/rel/ads/{id}/comments")
//    @ResponseBody
//    private List<Comment> getAds(@PathVariable long id) {
//
//    }

    // get all tags for an ad
//    @GetMapping("/rel/ads/{id}/tags")
//    @ResponseBody
//    private List<Tag> getTags(@PathVariable long id) {
//
//    }

    // get adDetails for a given comment
//    @GetMapping("/rel/ads/{id}/details")
//    @ResponseBody
//    private AdDetails getDetails(@PathVariable long id) {
//
//    }

    // view all tags in database
//    @GetMapping("/rel/tags")
//    @ResponseBody
//    private List<Tag> getTags() {
//
//    }

    // view all the ads for a given tag
//    @GetMapping("/rel/tags/{id}/ads")
//    @ResponseBody
//    private List<Ad> adsForTag(@PathVariable long id) {
//
//    }


    // ======================= CREATE EXAMPLES

    // create a new tag
//    @GetMapping("/rel/tags/create")
//    private String createTag() {
//
//    }

    // create a new ad
//    @GetMapping("/rel/ads/create-plain")
//    private String createNewAdWithoutTagsOrCommentsOrDetails() {
//
//    }

    // create a new ad with tags
//    @GetMapping("/rel/ads/create-w-tags")
//    private String createNewAdWithTagsWithoutCommentsOrDetails() {
//
//
//
//    }

    // add an existing tag to an ad
//    @GetMapping("/rel/ads/{adId}/add-tag/{tagId}")
//    private String addTagToAd(@PathVariable long adId, @PathVariable long tagId) {
//
//    }

    // create a new comment and add to an ad
//    @GetMapping("/rel/ads/{id}/add-comment")
//    private String addCommentToAd(@PathVariable long id) {
//
//    }

    // add or update a new ad detail for an ad
//    @GetMapping("/rel/ads/{id}/create/details")
//    private String addAdDetail(@PathVariable long id) {
//
//    }

    // create a new ad and ad detail
//    @GetMapping("/rel/ads/create-w-details")
//    private String createAdWithDetails() {
//
//    }

    // ======================= UPDATE EXAMPLES

    // update the name of a tag
//    @GetMapping("/rel/tags/{id}/update")
//    private String updateTag(@PathVariable long id) {
//
//    }

    // update a comment
//    @GetMapping("/rel/comments/{id}/update")
//    private String updateComment(@PathVariable long id) {
//
//    }

    // ======================= DELETE EXAMPLES

    // * delete a tag (do not delete any ads associated with it)
//    @GetMapping("/rel/tags/{id}/delete")
//    private String deleteTag(@PathVariable long id) {
//
//    }

    // remove a tag from an ad without deleting the ad or tag
//    @GetMapping("/rel/ads/{adId}/tags/{tagId}/remove")
//    private String removeTagFromAd(@PathVariable long adId, @PathVariable long tagId) {
//
//    }

    // delete a comment from an ad (do not delete the ad)
//    @GetMapping("/rel/comments/{id}/delete")
//    private String deleteComment(@PathVariable long id) {
//
//    }

    // remove the ad detail from an ad and delete from db
//    @GetMapping("/rel/ads/{id}/delete-details")
//    private String deleteDetails(@PathVariable long id) {
//
//    }

    // delete an ad (do not delete the tags but delete the comments and ad_detail)
//    @GetMapping("/rel/ads/{id}/delete")
//    private String deleteAd(@PathVariable long id) {
//
//    }

}
