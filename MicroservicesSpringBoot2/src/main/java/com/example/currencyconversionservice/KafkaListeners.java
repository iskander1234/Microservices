package com.example.currencyconversionservice;

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

    @Autowired
    private CurrencyExchangeServiceProxy proxy;

    private final ObjectMapper objectMapper;
//    @Value("${spring:kafka:template:inspection}")
//    private static String inspection;

    public KafkaListeners(CurrencyExchangeServiceProxy proxy, ObjectMapper objectMapper) {
        this.proxy = proxy;
        this.objectMapper = objectMapper;
//        this.inspection = inspection;
    }

}
