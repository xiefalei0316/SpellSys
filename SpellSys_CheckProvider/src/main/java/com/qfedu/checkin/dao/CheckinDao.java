package com.qfedu.checkin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfedu.entity.Checkin;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface CheckinDao extends BaseMapper<Checkin> {

    public Checkin findCheckDateByUId(@Param("uId") int uId);

    public List<Checkin> findByUId(@Param("uId") int uId);
}
