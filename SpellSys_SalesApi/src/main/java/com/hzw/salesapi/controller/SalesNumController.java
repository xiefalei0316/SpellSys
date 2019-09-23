package com.hzw.salesapi.controller;

import com.hzw.salesapi.service.SalesNumService;
import com.qfedu.common.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "销量榜单",tags = "销量榜单")
@RestController
public class SalesNumController {
    @Autowired
    private SalesNumService salesNumService;

    @ApiOperation(value = "新增销量榜单",notes ="新增销量榜单")
    @GetMapping("/api/sales/salesNum.do")
    public R salesNumtop() {
        return salesNumService.salesNumtop();
    }
}
