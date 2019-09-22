package com.qfedu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * <p>
 * 工单表
 * </p>
 *
 * @author rainbow
 * @since 2019-09-19
 */
@Data
@TableName("work_order")
public class WorkOrder extends Model<WorkOrder> {

    private static final long serialVersionUID = 1L;

   // @TableId(value = "wid", type = IdType.AUTO)
    private Integer wid;

    /**
     * 工单编号
     */
    private Integer number;

    /**
     * 店铺Id
     */
    private Integer store_id;

    /**
     * 订单状态
     */
    private Integer status;

    /**
     * 工单等级
     */
    private Integer rank;

    /**
     * 工单内容

     */
    private String content;

    /**
     * 问题分类
     */
    private Integer issue_class;

    /**
     * 创建时间
     */
    private Date create_time;

    /**
     * 修改时间
     */
    private Date modify_time;

    /**
     * 结束时间
     */
    private Date end_time;

    /**
     * 操作人Id

     */
    private Integer user_id;

    /**
     * 工单状态
     */
    private Integer work_status;

}
