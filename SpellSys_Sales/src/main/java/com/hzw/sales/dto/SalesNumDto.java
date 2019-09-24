package com.hzw.sales.dto;

import lombok.Data;

@Data
public class SalesNumDto {

    private Integer id;
    //商品id
    private Integer gId;
    //销量
    private Integer salesNum;

    private Double price;

    private String name;

    private String type;

    private String imgurl;
}
