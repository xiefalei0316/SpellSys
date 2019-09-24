package seckill.listener;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.qfedu.entity.entity.Goods;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seckill.dao.GoodsDao;

/**
 * @Author Lei
 * @Date 2019-9-21 16:06
 */

@RabbitListener(queues = "directQueueDecr")
@Component
public class GoodsDecr {

    @Autowired(required = false)
    private GoodsDao gDao;

    @RabbitHandler
    public void DecrGood(String msg){

        System.out.println(msg+"数据库预减");

        int gid = Integer.parseInt(msg.split("-")[1]);

        Goods goods = gDao.selectById(gid);


        goods.setInventory(goods.getInventory()-1);

        gDao.update(goods,new UpdateWrapper<Goods>().eq("id",gid));
    }
}
