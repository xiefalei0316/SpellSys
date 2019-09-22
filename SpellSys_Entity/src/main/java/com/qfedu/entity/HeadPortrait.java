package com.qfedu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * <p>
 * 头像表
 * </p>
 *
 * @author rainbow
 * @since 2019-09-19
 */
@Data
@TableName("head_portrait")
public class HeadPortrait extends Model<HeadPortrait> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "h_id", type = IdType.AUTO)
    private Integer h_id;

    /**
     * 客服Id
     */
    private Integer service_id;

    /**
     * 客户Id
     */
    private Integer client_id;

    /**
     * 头像URL
     */
    private String head_url;

}
