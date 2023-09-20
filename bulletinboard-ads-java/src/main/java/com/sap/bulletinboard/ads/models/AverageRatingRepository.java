package com.sap.bulletinboard.ads.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AverageRatingRepository extends JpaRepository<AverageRating, Long> {

    List<AverageRating> findByRevieweeEmail(String revieweeEmail);

    @Query("SELECT AVG(CAST(r.rating AS float)) from AverageRating r where r.revieweeEmail = :revieweeEmail")
    Number getAvgRatingByRevieweeEmail(String revieweeEmail);
}
