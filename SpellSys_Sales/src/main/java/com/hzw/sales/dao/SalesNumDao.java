package com.hzw.sales.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzw.sales.dto.SalesNumDto;

import java.util.List;

public interface SalesNumDao {

    //销量排行榜
    List<SalesNumDto> selectSalesNumTop();
}
