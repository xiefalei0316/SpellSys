package seckill.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @Author Lei
 * @Date 2019-9-21 15:49
 */

@Data
@TableName("orderform")
public class OrderGoods {
    private Integer id;
    private Integer goods_id;
    private  Integer num;
    private String address;
    private Date timenow;

}
