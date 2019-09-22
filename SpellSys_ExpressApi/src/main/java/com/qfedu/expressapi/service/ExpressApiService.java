package com.qfedu.expressapi.service;

import com.qfedu.common.dto.ExpressDto;
import com.qfedu.common.vo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description TODO
 * @interfaceName ExpressApiService
 * @Author Yama
 * @Date 2019/9/21 19:59
 * @Version V1.0
 */
@FeignClient("ExpressService")
public interface ExpressApiService {

    @GetMapping("/express/selectexpress.do")
    R findByExpress(@RequestParam("order_number") String orderNumber);

    @PostMapping("/express/addexpress.do")
    R addExpress(@RequestBody ExpressDto expressDto);
}
