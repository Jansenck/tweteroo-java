package com.tweteroo.api.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.tweteroo.api.model.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Id> {
    List<Tweet> findAllByOrderByIdDesc();
    List<Tweet> findByUsername(String username);
}
