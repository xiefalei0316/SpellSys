package seckill.controller;

import com.qfedu.common.vo.R;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import seckill.service.SeckillGoodsService;

import java.util.Date;

/**
 * @Author Lei
 * @Date 2019-9-21 1:24
 */
@Api(value = "秒杀商品的Crud",tags = "秒杀商品的Crud")
@Controller
public class SeckillGoodsOper {


    @Autowired(required = false)
    private SeckillGoodsService seckillGoodsService;


    @ApiOperation(value = "秒杀商品的添加",notes = "秒杀商品的添加")
    @ApiImplicitParams(@ApiImplicitParam(name = "id",value = "秒杀商品id"))
    @PostMapping("/save/seckillgoods")
    public R save(int id, Date beginTime, Date endTime){

        return seckillGoodsService.setSeckillGood(id,beginTime,endTime);

    }


}
