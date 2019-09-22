package com.qfedu.checkin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qfedu.common.vo.R;
import com.qfedu.entity.Checkin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CheckinService extends IService<Checkin> {

    public R insertCheck(int uId);

    public Checkin findCheckDateByUId(@Param("uId") int uId);

    public List<Checkin> findByUId(@Param("uId") int uId);
}
