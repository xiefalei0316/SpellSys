package com.qfedu.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @Description TODO
 * @Name ExpressNumbers
 * @Author Yama
 * @Date 2019/9/21 0:01
 * @Version V1.0
 */
@Data
@TableName("express_numbers")
public class ExpressNumbers {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    // 用户Id
    private Integer userId;
    // 订单编号
    private String orderNumber;
    // 店铺编号
    private Integer storeNumber;
    // 快递单号
    private String expressNumber;
    // 快递公司Id
    @JsonFormat
    private Integer expressId;
}
