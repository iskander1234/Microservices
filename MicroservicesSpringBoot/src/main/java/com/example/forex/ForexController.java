package com.example.forex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
public class ForexController {

    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeValueRepository repository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue
            (@PathVariable String from, @PathVariable String to){

        ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);

        exchangeValue.setPort(
                Integer.parseInt(environment.getProperty("local.server.port")));

        return exchangeValue;
    }

    @RequestMapping("/List")
    public List<ExchangeValue> getList(){
        List<ExchangeValue> list=  repository.findAll();
        return list;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ExchangeValue create(ExchangeValue value){
        return repository.save(value);
    }

    @DeleteMapping("/List/{id}")
    public void delete(Long id){
        repository.deleteById(id);
    }
}
