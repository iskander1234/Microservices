package com.example.getlist;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name="get-list-service")
public interface GetListServiceProxy {
    @GetMapping(value = "forex-services/List")
    public List<GetListBean> findAll();

    @PostMapping("application/json")
    public GetListBean save(GetListBean value);

    @DeleteMapping( "forex-services/List/{id}")
    public void deleteById(Long id);
}
