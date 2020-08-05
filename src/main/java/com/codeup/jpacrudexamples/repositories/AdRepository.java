package com.codeup.jpacrudexamples.repositories;

import com.codeup.jpacrudexamples.models.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// Ad is the reference type of the entity to CRUD
// Long is the reference type for the primary key of Ad
public interface AdRepository extends JpaRepository<Ad, Long> {

    // derived queries using the JPA query builder...
    Ad findByTitle(String title);
    Ad findFirstByOrderByTitleAsc();

    // custom examples using the query annotation
    // examples using JPQL / HQL
    @Query("from Ad a where a.id like ?1")
    Ad getAdById(long id);

    @Query("select title from Ad where LENGTH(title) < 10")
    List<String> getAdsOfCertainTitleLength();

    // using a native query
    @Query(nativeQuery = true, value = "SELECT title FROM ads WHERE LENGTH(title) < 10")
    List<String> getAdsOfCertainTitleLengthNative();

}
