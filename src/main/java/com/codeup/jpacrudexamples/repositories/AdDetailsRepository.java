package com.codeup.jpacrudexamples.repositories;

import com.codeup.jpacrudexamples.models.AdDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdDetailsRepository extends JpaRepository<AdDetails, Long> {
}
