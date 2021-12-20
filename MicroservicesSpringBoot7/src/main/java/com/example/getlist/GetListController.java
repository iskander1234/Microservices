package com.example.getlist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class GetListController {
    //private Logger logger = LoggerFactory.getLogger(this.getClass());


    private GetListServiceProxy proxy;

    @GetMapping("forex-services/List")
    public List<GetListBean> getList() {

//        Map<String, String> uriVariables = new HashMap<>();
//
//        ResponseEntity<GetListBean> responseEntity = new RestTemplate().getForEntity(
//                "http://localhost:8000/currency-exchange/", GetListBean.class,
//                uriVariables);
//
//        List<GetListBean> response = proxy.findAll();

        return proxy.findAll();
    }

//    @GetMapping("/currency-exchange/list")
//    public List<GetListBean> getList() {
//
//        List<GetListBean> response = proxy.getList();
//
//        //logger.info("{}", response);
//
//        return response;
//    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public GetListBean create(GetListBean value){
        return proxy.save(value);
    }

    @DeleteMapping( "forex-services/List/{id}")
    public void delete(Long id){
        proxy.deleteById(id);
    }

}
