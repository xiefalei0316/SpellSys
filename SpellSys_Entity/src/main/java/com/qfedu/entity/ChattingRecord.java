package com.qfedu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 聊天记录
 * </p>
 *
 * @author rainbow
 * @since 2019-09-19
 */
@Data
@TableName("chtting_record")
public class ChattingRecord extends Model<ChattingRecord> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "cid", type = IdType.AUTO)
    private Integer cid;

    /**
     * 客户Id
     */
    private Integer client_id;

    /**
     * 客服Id
     */
    private Integer user_id;

    /**
     * 店铺Id
     */
    private Integer store_id;

    /**
     * 发送时间
     */
    private Date create_time;

    /**
     * 聊天内容
     */
    private String chat_content;

}
