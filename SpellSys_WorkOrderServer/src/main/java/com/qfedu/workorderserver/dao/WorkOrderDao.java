package com.qfedu.workorderserver.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfedu.entity.WorkOrder;

/**
 * @Description TODO
 * @interfaceName WorkOrderDao
 * @Author Yama
 * @Date 2019/9/20 9:33
 * @Version V1.0
 */
public interface WorkOrderDao extends BaseMapper<WorkOrder> {

    /**
     * 创建工单
     * @param workOrder
     * @return
     */
    int addWorkOrder(WorkOrder workOrder);

}
