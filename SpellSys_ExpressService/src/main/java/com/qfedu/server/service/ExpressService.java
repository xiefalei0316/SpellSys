package com.qfedu.server.service;


import com.qfedu.common.vo.R;
import com.qfedu.common.dto.ExpressDto;

/**
 * @Description TODO
 * @Name ExpressService
 * @Author Yama
 * @Date 2019/9/21 0:38
 * @Version V1.0
 */
public interface ExpressService {

    /**
     * 查询物流信息
     * @param orderNumber
     * @return
     */
    public R findByExpress(String orderNumber);

    public R<String> addExpress(ExpressDto expressDto);
}
