package com.qfedu.server.vo;

import lombok.Data;

/**
 * @Description TODO
 * @Name ExpressVo
 * @Author Yama
 * @Date 2019/9/21 9:11
 * @Version V1.0
 */
@Data
public class ExpressVo {
    private Integer id;
    private String expressNumber;
    private String expressType;
    private String expressName;
    private Integer numOfQueries;
}
