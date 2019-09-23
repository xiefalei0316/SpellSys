package com.hzw.salesapi.service;

import com.qfedu.common.vo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("salesHzw")
public interface SalesNumService {

    @GetMapping("/api/sales/salesNum.do")
    public R salesNumtop();

}
