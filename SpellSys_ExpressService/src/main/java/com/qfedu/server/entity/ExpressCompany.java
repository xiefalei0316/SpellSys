package com.qfedu.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description TODO
 * @Name ExpressCompany
 * @Author Yama
 * @Date 2019/9/21 0:02
 * @Version V1.0
 */
@Data
@TableName("express_company")
public class ExpressCompany {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    // 快递编号
    private String expressType;
    // 快递公司
    private String expressName;
}
