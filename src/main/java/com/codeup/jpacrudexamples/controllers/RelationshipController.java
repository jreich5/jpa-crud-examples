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
    @GetMapping("/rel/ads")
    @ResponseBody
    private List<Ad> getAds() {
        return adsDao.findAll();
    }

    // get all comments for an ad
    @GetMapping("/rel/ads/{id}/comments")
    @ResponseBody
    private List<Comment> getAds(@PathVariable long id) {
        return adsDao.getOne(id).getComments();
    }

    // get all tags for an ad
    @GetMapping("/rel/ads/{id}/tags")
    @ResponseBody
    private List<Tag> getTags(@PathVariable long id) {
        return adsDao.getOne(id).getTags();
    }

    // get adDetails for a given comment
    @GetMapping("/rel/ads/{id}/details")
    @ResponseBody
    private AdDetails getDetails(@PathVariable long id) {
        return adsDao.getOne(id).getAdDetails();
        // OR...
//        return detailsDao.getOne(id);
    }

    // view all tags in database
    @GetMapping("/rel/tags")
    @ResponseBody
    private List<Tag> getTags() {
        return tagsDao.findAll();
    }

    // view all the ads for a given tag
    @GetMapping("/rel/tags/{id}/ads")
    @ResponseBody
    private List<Ad> adsForTag(@PathVariable long id) {
        return tagsDao.getOne(id).getAds();
    }


    // ======================= CREATE EXAMPLES

    // create a new tag
    @GetMapping("/rel/tags/create")
    private String createTag() {
        Tag tagToCreate = new Tag("Tag: " + new Date().toString());
        tagsDao.save(tagToCreate);
        return "redirect:/rel/tags";
    }

    // create a new ad
    @GetMapping("/rel/ads/create-plain")
    private String createNewAdWithoutTagsOrCommentsOrDetails() {
        Ad newAd = new Ad("Ad Created Today " + new Date().toString(), "This ad was created: " + new Date().toString());
        adsDao.save(newAd);
        return "redirect:/rel/ads";
    }

    // create a new ad with tags
    @GetMapping("/rel/ads/create-w-tags")
    private String createNewAdWithTagsWithoutCommentsOrDetails() {

        // create new ad
        Ad newAd = new Ad("Ad w/Tags! " + new Date().toString(), "This ad was created: " + new Date().toString());

        // retrieve a list of tag objects from the DB and add the tags to the ad with the ad tag method
        List<Long> tagIds = Arrays.asList(1L, 2L, 3L); // the tags with these ids will be added to the new Ad
        for (long id : tagIds) {
            Tag tagToAdd = tagsDao.getOne(id); // retrieve a tag for each id number
            newAd.addTag(tagToAdd); // add tag to ad
        }
        adsDao.save(newAd);
        return "redirect:/rel/ads";

    }

    // add an existing tag to an ad
    @GetMapping("/rel/ads/{adId}/add-tag/{tagId}")
    private String addTagToAd(@PathVariable long adId, @PathVariable long tagId) {
        Ad adToAddTagTo = adsDao.getOne(adId);
        Tag tagToAddToAd = tagsDao.getOne(tagId);
        adToAddTagTo.addTag(tagToAddToAd);
        adsDao.save(adToAddTagTo);
        return "redirect:/rel/ads";
    }

    // create a new comment and add to an ad
    @GetMapping("/rel/ads/{id}/add-comment")
    private String addCommentToAd(@PathVariable long id) {
        Comment comment = new Comment("This is a newly created comment from " + new Date().toString());
        Ad adToAddCommentTo = adsDao.getOne(id);
        comment.setAd(adToAddCommentTo); // without this step, the comment will be saved but not associated with the ad!
        adToAddCommentTo.getComments().add(comment);
        adsDao.save(adToAddCommentTo);
        return "redirect:/rel/ads";
    }

    // add or update a new ad detail for an ad
    @GetMapping("/rel/ads/{id}/create/details")
    private String addAdDetail(@PathVariable long id) {
        String extraInfo = "This is extra info"; // assuming this comes from a form
        Ad ad = adsDao.getOne(id);
        AdDetails adDetails;
        // if ad details doesn't already exist for an ad, create it...
        if (ad.getAdDetails() == null) {
            adDetails = new AdDetails(extraInfo);
        // ...otherwise, update the existing details
        } else {
            adDetails = ad.getAdDetails();
            adDetails.setExtraInfo(extraInfo);
        }
        // regardless, update in the database
        ad.setAdDetails(adDetails);
        adsDao.save(ad);
        return "redirect:/rel/ads/" + id + "/details";
    }

    // create a new ad and ad detail
    @GetMapping("/rel/ads/create-w-details")
    private String createAdWithDetails() {
        Ad newAd = new Ad("Ad w/Details " + new Date().toString(), "Yadda yadda");
        AdDetails adDetails = new AdDetails("This is some extra info for a brand new ad!");
        newAd.setAdDetails(adDetails);
        Ad savedAd = adsDao.save(newAd);
        return "redirect:/rel/ads/" + savedAd.getId() + "/details";
    }

    // ======================= UPDATE EXAMPLES

    // update the name of a tag
    @GetMapping("/rel/tags/{id}/update")
    private String updateTag(@PathVariable long id) {
        String updatedName = "Updated Tag " + new Date().toString();
        Tag tagToUpdate = tagsDao.getOne(id);
        tagToUpdate.setName(updatedName);
        tagsDao.save(tagToUpdate);
        return "redirect:/rel/tags";
    }

    // update a comment
    @GetMapping("/rel/comments/{id}/update")
    private String updateComment(@PathVariable long id) {
        String updatedContent = "Updated comment " + new Date().toString();
        Comment commentToUpdate = commentsDao.getOne(id);
        commentToUpdate.setContent(updatedContent);
        commentsDao.save(commentToUpdate);
        return "redirect:/rel/ads";
    }

    // ======================= DELETE EXAMPLES

    // * delete a tag (do not delete any ads associated with it)
    @GetMapping("/rel/tags/{id}/delete")
    private String deleteTag(@PathVariable long id) {
        tagsDao.deleteById(id);
        return "redirect:/rel/tags";
    }

    // remove a tag from an ad without deleting the ad or tag
    @GetMapping("/rel/ads/{adId}/tags/{tagId}/remove")
    private String removeTagFromAd(@PathVariable long adId, @PathVariable long tagId) {
        Ad adToRemoveTagFrom = adsDao.getOne(adId);
        Tag tagToRemoveFromAd = tagsDao.getOne(tagId);
        adToRemoveTagFrom.removeTag(tagToRemoveFromAd); // see the Ad entity class for the removeTag method
        adsDao.save(adToRemoveTagFrom);
        return "redirect:/rel/ads";
    }

    // delete a comment from an ad (do not delete the ad)
    @GetMapping("/rel/comments/{id}/delete")
    private String deleteComment(@PathVariable long id) {
        commentsDao.deleteById(id);
        return "redirect:/rel/ads";
    }

    // remove the ad detail from an ad and delete from db
    @GetMapping("/rel/ads/{id}/delete-details")
    private String deleteDetails(@PathVariable long id) {
        Ad adToRemoveDetails = adsDao.getOne(id);
        AdDetails adDetails = adToRemoveDetails.getAdDetails();
        adToRemoveDetails.setAdDetails(null);
        adsDao.save(adToRemoveDetails);
        detailsDao.deleteById(adDetails.getId());
        return "redirect:/rel/ads";
    }

    // delete an ad (do not delete the tags but delete the comments and ad_detail)
    @GetMapping("/rel/ads/{id}/delete")
    private String deleteAd(@PathVariable long id) {
        adsDao.deleteById(id);
        return "redirect:/rel/ads";
    }

}
