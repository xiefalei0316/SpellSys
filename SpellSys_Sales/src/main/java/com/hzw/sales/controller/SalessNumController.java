package com.hzw.sales.controller;

import com.hzw.sales.service.SalesNumService;
import com.qfedu.common.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalessNumController {

    @Autowired
    private SalesNumService salesNumService;
    //查询销量浏览榜单
    @GetMapping("/api/sales/salesNum.do")
    public R salesNumtop(){
        return salesNumService.SalesNumTop();
    }
}
