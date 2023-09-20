package com.sap.bulletinboard.ads.services;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sap.bulletinboard.ads.dto.AverageRatingDto;
import com.sap.bulletinboard.ads.models.AverageRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AverageRatingService
{
    private Double averageRating;

    @Autowired
    AverageRatingRepository repository;
    @JsonProperty("average_rating")
    public Double getAverageRating() {
        return averageRating;
    }

    @JsonProperty("average_rating")
    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }
    public AverageRatingDto saveAverageRating(AverageRatingDto dto) {
        com.sap.bulletinboard.ads.models.AverageRating e = dtoToEntity(dto);
        return entityToDto(repository.save(e));
    }

    public com.sap.bulletinboard.ads.models.AverageRating dtoToEntity(AverageRatingDto dto){

        com.sap.bulletinboard.ads.models.AverageRating e = new com.sap.bulletinboard.ads.models.AverageRating();
        e.setRating(dto.getAverageRating().intValue());
        e.setRevieweeEmail(dto.getRevieweeEmail());
        return e;
    }

    public AverageRatingDto entityToDto(com.sap.bulletinboard.ads.models.AverageRating e){

        AverageRatingDto dto = new AverageRatingDto();
        dto.setAverageRating(e.getRating());
        dto.setRevieweeEmail(e.getRevieweeEmail());
        return dto;
    }
}
