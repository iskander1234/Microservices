package com.example.adminservice.service.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;

@Service
public class KafkaListeners {
   @Autowired
    private static final Logger logger = LoggerFactory.getLogger(KafkaListeners.class);

    private final SomeClassService someClassService;
    private final ObjectMapper objectMapper;
//    @Value("${spring:kafka:template:inspection}")
//    private static String inspection;

    public KafkaListeners(someClassService someClassService, ObjectMapper objectMapper) {
        this.someClassService = someClassService;
        this.objectMapper = objectMapper;
//        this.inspection = inspection;
    }

//
//    @KafkaListener(topics = "${spring.kafka.template.inspection}")
//    public boolean inspectionListener(String object) throws IOException, ServiceException, ParseException {
//        Message message = objectMapper.readValue(object, Message.class);
//        logger.info("INSPECTION: " + message);
//        someClassService.someClassService(message.getRequest());
//        return true;
//    }
//
//    @KafkaListener(topics = "${spring.kafka.template.formation}")
//    public boolean Listener(String object) throws IOException, ServiceException {
//        Request message = objectMapper.readValue(object, Request.class);
//        logger.info("FORMATION: " + message);
//        someClassService.carsFormation(message);
//        return true;
//    }

}
