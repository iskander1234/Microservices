package com.example.forex;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@FeignClient(name = "getlist", url = "localhost:8099")
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long>{
    ExchangeValue findByFromAndTo(String from, String to);

    @GetMapping(value = "/List")
    List<ExchangeValue> findAll();

    @PostMapping("/application/json")
    public ExchangeValue save(ExchangeValue value);

    @DeleteMapping( "/List/{id}")
    public void deleteById(Long id);

}
