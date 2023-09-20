package com.sap.bulletinboard.reviews.queue;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sap.bulletinboard.reviews.controller.dto.AverageRatingDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;



@Component
public class QueueProducer {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${fanout.exchange}")
    private String fanoutExchange;

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public QueueProducer(RabbitTemplate rabbitTemplate) {
        super();
        this.rabbitTemplate = rabbitTemplate;
    }

    public void produce(AverageRatingDto dto) throws Exception {
        logger.info("Storing notification...");
        rabbitTemplate.setExchange(fanoutExchange);
        rabbitTemplate.convertAndSend(new ObjectMapper().writeValueAsString(dto));
        logger.info("Notification stored in queue sucessfully");
    }

}