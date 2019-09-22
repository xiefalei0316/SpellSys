package com.qfedu.workorderserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qfedu.common.vo.R;
import com.qfedu.entity.WorkOrder;
import com.qfedu.common.dto.WorkOrderDto;

/**
 * @Description TODO
 * @interfaceName WorkOrderService
 * @Author Yama
 * @Date 2019/9/20 9:38
 * @Version V1.0
 */
public interface WorkOrderService extends IService<WorkOrder> {

    /**
     * 创建工单
     * @param workOrderDto 传入的对象是一个 WorkOrderDto 类对象
     * @return
     */
    R<String> addWorkOrder(WorkOrderDto workOrderDto);
}
