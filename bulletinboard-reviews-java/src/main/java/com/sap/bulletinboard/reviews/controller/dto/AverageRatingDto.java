package com.sap.bulletinboard.reviews.controller.dto;

public class AverageRatingDto {
    Number averageRating;
    private String revieweeEmail;

    public AverageRatingDto() {
    }

    public AverageRatingDto(Number averageRating, String revieweeEmail) {
        this.averageRating = averageRating;
        this.revieweeEmail = revieweeEmail;
    }

    public Number getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Number averageRating) {
        this.averageRating = averageRating;
    }

    public String getRevieweeEmail() {
        return revieweeEmail;
    }

    public void setRevieweeEmail(String revieweeEmail) {
        this.revieweeEmail = revieweeEmail;
    }
}
