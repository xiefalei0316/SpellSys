package com.qfedu.spell.controller;

import com.qfedu.common.vo.R;
import com.qfedu.spell.service.CheckService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "签到操作",tags = "签到操作")
@RestController
public class CheckController {
    @Autowired
    private CheckService checkService;

    @ApiOperation(value = "新增签到记录",notes ="新增签到记录")
    @PostMapping("spell/checkin.do")
    public R userCheck(@RequestBody int uId) {
        return checkService.CheckinById(uId);
    }
}
