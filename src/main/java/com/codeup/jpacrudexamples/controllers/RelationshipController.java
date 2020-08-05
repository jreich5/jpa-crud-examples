package com.codeup.jpacrudexamples.controllers;

import com.codeup.jpacrudexamples.models.Ad;
import com.codeup.jpacrudexamples.repositories.AdDetailsRepository;
import com.codeup.jpacrudexamples.repositories.AdRepository;
import com.codeup.jpacrudexamples.repositories.CommentRepository;
import com.codeup.jpacrudexamples.repositories.TagRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RelationshipController {

    private final AdRepository adsDao;
    private final CommentRepository commsDao;
    private final TagRepository tagDao;
    private final AdDetailsRepository deetsDao;

    public RelationshipController(AdRepository adsDao, CommentRepository commsDao, TagRepository tagDao, AdDetailsRepository deetsDao) {
        this.adsDao = adsDao;
        this.commsDao = commsDao;
        this.tagDao = tagDao;
        this.deetsDao = deetsDao;
    }

    // ======================= READ EXAMPLES

    // get all ads
    @GetMapping("/rel/ads")
    @ResponseBody
    private List<Ad> getAds() {
        return adsDao.findAll();
    }

    // get all comments for an ad

    // get all tags for an ad

    // get adDetails for a given comment


    // ======================= CREATE EXAMPLES

    // create a new tag

    // create a new ad

    // add an new tag to an ad

    // create a new comment and add to an ad

    // create a new ad detail and ad to an ad

    // create a new ad and ad detail



    // ======================= UPDATE EXAMPLES

    // update the name of a tag

    // update the extra info of an ad_detail

    // update a comment



    // ======================= DELETE EXAMPLES

    // delete a tag (do not delete any ads associated with it)

    // from a tag from an ad without deleting it

    // delete a comment from an ad (do not delete the

    // delete an ad detail from an ad

    // delete an ad (do not delete the tags but delete the comments and ad_detail)



}
