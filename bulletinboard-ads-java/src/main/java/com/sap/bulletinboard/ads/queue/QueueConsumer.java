package com.sap.bulletinboard.ads.queue;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sap.bulletinboard.ads.dto.AverageRatingDto;
import com.sap.bulletinboard.ads.services.AverageRatingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.stereotype.Component;


@Component
public class QueueConsumer {

    @Autowired
    AverageRatingService averageRatingService;

    protected Logger logger = LoggerFactory.getLogger(getClass());

    public void receiveMessage(String message) {
        logger.info("Received: " + message);
        processMessage(message);
    }

    public void receiveMessage(byte[] message) {
        String strMessage = new String(message);
        logger.info("Received (No String) " + strMessage);
        processMessage(strMessage);

    }


    private void processMessage(String message) {
        try {
            AverageRatingDto ratingDTO = new ObjectMapper().readValue(message, AverageRatingDto.class);
            averageRatingService.saveAverageRating(ratingDTO);
        } catch (JsonParseException e) {
            logger.warn("Bad JSON in message: " + message);
        } catch (JsonMappingException e) {
            logger.warn("cannot map JSON to NotificationRequest: " + message);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

}