package com.codeup.jpacrudexamples.repositories;

import com.codeup.jpacrudexamples.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
