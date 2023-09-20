package com.sap.bulletinboard.ads.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "averagerating")
public class AverageRating {
    @Id
    private String revieweeEmail;
    private Integer rating;

    public String getRevieweeEmail() {
        return revieweeEmail;
    }

    public void setRevieweeEmail(String revieweeEmail) {
        this.revieweeEmail = revieweeEmail;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
