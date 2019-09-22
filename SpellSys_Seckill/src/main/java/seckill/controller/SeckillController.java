package seckill.controller;

import com.qfedu.common.util.RUtil;
import com.qfedu.common.vo.R;
import com.qfedu.entity.Seckill;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;
import seckill.service.SeckillGoodsService;
import seckill.service.SeckillService;

/**
 * @Author Lei
 * @Date 2019-9-20 20:45
 */
@RestController
@Api(value = "秒杀", tags = "秒杀")
public class SeckillController {

    @Autowired(required = false)
    private SeckillService seckillService;

    @Autowired(required = false)
    private SeckillGoodsService seckillGoodsService;

    @ApiOperation(value = "保存", notes = "保存")
    @PostMapping("/save")
    public R save(Seckill seckill) {
        return RUtil.setR(seckillService.saveOrUpdate(seckill), "新增成功");

    }

    //判断该秒杀商品活动是否开始
    @ApiOperation(value = "是否可以秒杀", notes = "是否可以秒杀")
    @GetMapping("/booleanSeckill")
    @ApiResponses({
            @ApiResponse(code = 400, message = "该商品活动未开始"),
            @ApiResponse(code = 200, message = "活动开始")}
    )
    @ApiImplicitParam(name = "id",value = "用户秒杀商品g_id",required = true)
    public R getBooleanSeckill(int id) {

        return seckillGoodsService.QuerySeckillTime(id);
    }

    @GetMapping("/getSeckillGood")
    @ApiOperation(value = "抢购秒杀商品",notes = "抢购秒杀商品")
    public R getSeckillGood(Integer id){
        Integer uid =2;
        return seckillGoodsService.getSeckillGood(id,uid);
    }

}
