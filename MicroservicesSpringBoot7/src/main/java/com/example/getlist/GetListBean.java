package com.example.getlist;

import lombok.*;
import javax.persistence.*;


import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class GetListBean {
    @Id
    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private int port;


    public GetListBean(Long id, String from, String to, BigDecimal conversionMultiple, int port) {
        super();
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
        this.port = port;
    }

    public GetListBean() {

    }
}
