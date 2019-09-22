package com.qfedu.api.service;

import com.qfedu.common.dto.WorkOrderDto;
import com.qfedu.common.vo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Description TODO
 * @Name WorkOrderServerService
 * @Author Yama
 * @Date 2019/9/20 10:15
 * @Version V1.0
 */
@FeignClient("WorkOrderServer")
public interface WorkOrderServerService {
    /**
     * 创建工单
     * @param workOrderDto
     * @return
     */
    @PostMapping("/workorderserver/addworkorder.do")
    R addWorkOrder(@RequestBody WorkOrderDto workOrderDto);
}
