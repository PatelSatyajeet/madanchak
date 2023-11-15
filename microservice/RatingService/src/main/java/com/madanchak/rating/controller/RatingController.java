package com.madanchak.rating.controller;

import com.madanchak.rating.model.Rating;
import com.madanchak.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private RatingService ratingService;
    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        Rating rating4=ratingService.saveRating(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(rating4);
    }
    @GetMapping
    public ResponseEntity<List<Rating>> findAllRating(){
        List<Rating> allRating=ratingService.getAllRating();
        return ResponseEntity.ok(allRating);
    }
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> findRatingsByUserId(@PathVariable String userId){
        List<Rating> allRatings=ratingService.getRatingByUserId(userId);
        return ResponseEntity.ok(allRatings);
    }
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> findRatingsByHotelId(@PathVariable String hotelId){
        List<Rating> allRatingss=ratingService.getRatingByHotelId(hotelId);
        return ResponseEntity.ok(allRatingss);
    }
}
