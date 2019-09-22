package com.qfedu.workorderserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qfedu.common.util.RUtil;
import com.qfedu.common.vo.R;
import com.qfedu.entity.WorkOrder;
import com.qfedu.workorderserver.dao.WorkOrderDao;
import com.qfedu.common.dto.WorkOrderDto;
import com.qfedu.workorderserver.service.WorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Description TODO
 * @Name WorkOrderServiceImpl
 * @Author Yama
 * @Date 2019/9/20 9:39
 * @Version V1.0
 */
@Service
public class WorkOrderServiceImpl extends ServiceImpl<WorkOrderDao, WorkOrder> implements WorkOrderService {

    @Autowired(required = false)
    private WorkOrderDao workOrderDao;

    @Override
    public R<String> addWorkOrder(WorkOrderDto workOrderDto) {
        WorkOrder workOrder = new WorkOrder();
        workOrder.setNumber(workOrderDto.getNum());
        workOrder.setStore_id(workOrderDto.getSid());
        workOrder.setStatus(workOrderDto.getStatus());
        workOrder.setRank(workOrderDto.getWorkOrderRank());
        workOrder.setContent(workOrderDto.getContent());
        workOrder.setIssue_class(workOrderDto.getIssueClass());
        workOrder.setUser_id(workOrderDto.getUserId());
        workOrder.setWork_status(workOrderDto.getWorkStatus());
        return RUtil.setR(workOrderDao.insert(workOrder) > 0, "创建工单");
    }
}
