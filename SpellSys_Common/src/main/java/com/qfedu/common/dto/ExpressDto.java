package com.qfedu.common.dto;

import lombok.Data;

/**
 * @Description TODO
 * @Name ExpressDto
 * @Author Yama
 * @Date 2019/9/22 11:19
 * @Version V1.0
 */
@Data
public class ExpressDto {
    //  录入快递信息的员工编号
    private Integer uId;
    private String orderNum;
    private Integer storeNum;
    private String expressNum;
    private Integer expressId;
}
