package seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qfedu.entity.Seckill;
import org.springframework.stereotype.Service;
import seckill.dao.SeckillDao;
import seckill.service.SeckillService;

/**
 * @Author Lei
 * @Date 2019-9-20 20:44
 */

@Service
public class SeckillServiceImpl extends ServiceImpl<SeckillDao, Seckill>  implements SeckillService {
}
