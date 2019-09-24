package com.qfedu.spell.service;

import com.qfedu.common.vo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("CheckProvider")
public interface CheckService {

    @PostMapping("spell/checkin.do")
    public R CheckinById(@RequestBody int uId);

}
