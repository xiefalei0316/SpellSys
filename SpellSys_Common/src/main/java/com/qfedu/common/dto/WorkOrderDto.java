package com.qfedu.common.dto;

import lombok.Data;

import java.util.Date;

/**
 * @Description TODO
 * @Name WorkOrderDto
 * @Author Yama
 * @Date 2019/9/20 9:35
 * @Version V1.0
 */
@Data
public class WorkOrderDto {
    private Integer wid;

    /**
     * 工单编号
     */
    private Integer num;

    /**
     * 店铺Id
     */
    private Integer sid;

    /**
     * 订单状态
     */
    private Integer status;

    /**
     * 工单等级
     */
    private Integer workOrderRank;

    /**
     * 工单内容

     */
    private String content;

    /**
     * 问题分类
     */
    private Integer issueClass;


    /**
     * 操作人Id

     */
    private Integer userId;

    /**
     * 工单状态
     */
    private Integer workStatus;
}
