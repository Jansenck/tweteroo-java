package com.tweteroo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.model.Tweet;
import com.tweteroo.api.repositories.TweetRepository;

@RestController
@RequestMapping("/api/tweet")
public class TweetController {
    @Autowired
    private TweetRepository repository;


    @PostMapping
    public void create(@RequestBody TweetDTO req){
       repository.save(new Tweet(req));
    }

    @GetMapping
    public List<Tweet> getTweets(@RequestParam(defaultValue = "1") int page) {
        int pageSize = 5;
        int offset = (page - 1) * pageSize;
        List<Tweet> tweets = repository.findAllByOrderByIdDesc();
        return tweets.subList(offset, Math.min(offset + pageSize, tweets.size()));
    }

    @GetMapping("/{username}")
    public List<Tweet> getByUsername(@PathVariable String username){
        List<Tweet> tweets = repository.findByUsername(username); 
        return tweets;
    }

}
