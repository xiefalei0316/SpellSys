package com.qfedu.checkin.controller;


import com.qfedu.checkin.service.CheckinService;
import com.qfedu.common.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckController {

    @Autowired
    private CheckinService checkinService;

    @PostMapping("spell/checkin.do")
    public R CheckinById(@RequestBody int uId) {
        return checkinService.insertCheck(uId);
    }
}
