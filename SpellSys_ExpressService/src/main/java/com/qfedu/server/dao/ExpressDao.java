package com.qfedu.server.dao;

import com.qfedu.server.entity.ExpressNumbers;
import com.qfedu.server.vo.ExpressVo;

/**
 * @Description TODO
 * @interfaceName ExpressDao
 * @Author Yama
 * @Date 2019/9/21 0:30
 * @Version V1.0
 */
public interface ExpressDao {
    /**
     * 通过订单编号查询快递单号
     * @param orderNumber 传入的参数是快递单号
     * @return
     */
    ExpressVo findByExpress(String orderNumber);

    /**
     *  发货录入快递单号
     * @param expressNumbers
     * @return
     */
    int addExpress(ExpressNumbers expressNumbers);
}
