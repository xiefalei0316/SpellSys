package com.qfedu.expressapi.api;

import com.qfedu.common.dto.ExpressDto;
import com.qfedu.common.vo.R;
import com.qfedu.expressapi.service.ExpressApiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description TODO
 * @Name ExpressApi
 * @Author Yama
 * @Date 2019/9/21 20:14
 * @Version V1.0
 */
@Api(value = "快递信息", tags = "快递信息操作，真实数据")
@RestController
public class ExpressApi {

    @Autowired
    private ExpressApiService expressApiService;

    @ApiOperation(value = "查询物流信息", tags = "实现查询物流信息操作")
    @GetMapping("/express/api.do")
    public R findByExpress(@RequestParam("order_number") String orderNumber) {
        return expressApiService.findByExpress(orderNumber);
    }

    @ApiOperation(value = "录入发货信息", tags = "实现录入快递单号操作")
    @PostMapping("/express/addexpress/api.do")
    public R addExpress(@RequestBody ExpressDto expressDto) {
        return expressApiService.addExpress(expressDto);
    }

}
