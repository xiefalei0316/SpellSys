package com.qfedu.checkin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qfedu.common.vo.R;
import com.qfedu.entity.Checkin;

public interface CheckinService extends IService<Checkin> {

    public R insertCheck(int uId);
}
