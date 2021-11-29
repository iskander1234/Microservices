//package com.example.adminservice.service.kafka;
//
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.AllArgsConstructor;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//@Service
//@AllArgsConstructor
//public class KafkaProducerMethods {
//    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerMethods.class);
//    private KafkaTemplate<String, String> kafkaTemplate;
//    private ObjectMapper objectMapper;
//
////    @Value("${spring.kafka.template.default-topic}")
//    private static String producerTopic;
//
//    public String sendToNotificationService(Object object){
//        logger.info(String.format("#### -> Noti Service message -> %s", writeValueAsString(object), "dev-notification"));
//        this.kafkaTemplate.send("dev-notification", "noti", writeValueAsString(object));
//        return "ok";
//    }
//
//
//
//    private String writeValueAsString(Object object) {
//        try {
//            return objectMapper.writeValueAsString(object);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Writing value to JSON failed: " + object.toString());
//        }
//    }
//}
