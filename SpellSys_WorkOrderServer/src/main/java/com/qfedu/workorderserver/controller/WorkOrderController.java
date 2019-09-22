package com.qfedu.workorderserver.controller;

import com.qfedu.common.vo.R;
import com.qfedu.common.dto.WorkOrderDto;
import com.qfedu.workorderserver.service.WorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description TODO
 * @Name WorkOrderController
 * @Author Yama
 * @Date 2019/9/20 10:01
 * @Version V1.0
 */
@RestController
public class WorkOrderController {

    @Autowired
    private WorkOrderService workOrderService;

    @PostMapping("/workorderserver/addworkorder.do")
    public R addWorkOrder(@RequestBody WorkOrderDto workOrderDto) {
        return workOrderService.addWorkOrder(workOrderDto);
    }
}
