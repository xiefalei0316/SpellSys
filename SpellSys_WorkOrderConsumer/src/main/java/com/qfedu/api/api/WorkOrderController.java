package com.qfedu.api.api;

import com.qfedu.api.service.WorkOrderServerService;
import com.qfedu.common.dto.WorkOrderDto;
import com.qfedu.common.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description TODO
 * @Name WorkOrderController
 * @Author Yama
 * @Date 2019/9/20 10:21
 * @Version V1.0
 */
@Api(value = "操作工单", tags = "操作工单操作")
@RestController
public class WorkOrderController {

    @Autowired
    private WorkOrderServerService workOrderServerService;

    @ApiOperation(value = "创建工单", notes = "实现创建工单操作")
    @PostMapping("/api/workorderserver/addworkorder.do")
    public R addWorkOrder(@RequestBody WorkOrderDto workOrderDto) {
        return workOrderServerService.addWorkOrder(workOrderDto);
    }
}
