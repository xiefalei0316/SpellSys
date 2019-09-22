package com.qfedu.server.controller;

import com.qfedu.common.vo.R;
import com.qfedu.common.dto.ExpressDto;
import com.qfedu.server.service.ExpressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description TODO
 * @Name ExpressController
 * @Author Yama
 * @Date 2019/9/21 9:43
 * @Version V1.0
 */
@RestController
public class ExpressController {

    @Autowired
    private ExpressService expressService;

    @GetMapping("/express/selectexpress.do")
    public R findByExpress(@RequestParam("order_number") String orderNumber) {
        return expressService.findByExpress(orderNumber);
    }

    @PostMapping("/express/addexpress.do")
    public R addExpress(@RequestBody ExpressDto expressDto) {
        return expressService.addExpress(expressDto);
    }
}
