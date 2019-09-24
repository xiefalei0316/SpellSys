package com.qfedu.server.service.impl;

import com.qfedu.common.util.RUtil;
import com.qfedu.common.vo.R;
import com.qfedu.server.cache.JedisUtil;
import com.qfedu.server.dao.ExpressDao;
import com.qfedu.common.dto.ExpressDto;
import com.qfedu.server.entity.ExpressNumbers;
import com.qfedu.server.service.ExpressService;
import com.qfedu.server.util.ExpressUtils;
import com.qfedu.server.vo.ExpressVo;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Name ExpressServiceImpl
 * @Author Yama
 * @Date 2019/9/21 0:38
 * @Version V1.0
 */
@Service
public class ExpressServiceImpl implements ExpressService {

    @Autowired(required = false)
    private ExpressDao expressDao;

    @Override
    public R findByExpress(String orderNumber) {
        JedisUtil instance = JedisUtil.getInstance();
        ExpressVo express = expressDao.findByExpress(orderNumber);
        if (orderNumber != null) {
            if (instance.get("express" + express.getId()) != null) {
                // 返回json
                return RUtil.setOK("查询成功", instance.get("express" + express.getId()));
            } else {
                String host = "http://wuliu.market.alicloudapi.com";
                String path = "/kdi";
                String method = "GET";
                // AppCode
                String appcode = "c726c9ea8e9e47e0ae13af5e406abd46";
                Map<String, String> headers = new HashMap<String, String>();
                headers.put("Authorization", "APPCODE " + appcode);
                Map<String, String> querys = new HashMap<String, String>();
                // 请求参数 快递单号
                querys.put("no", express.getExpressNumber());
                // 请求参数 快递公司
                querys.put("type", express.getExpressType());

                if (querys != null) {
                    expressDao.modifyNumberOfQueries(express.getId());
                }

                HttpResponse response = null;
                try {
                    response = ExpressUtils.doGet(host, path, method, headers, querys);
                    // 随机Key值存活秒数
                    int time = (int)(Math.random() * 3600) + 1;
                    instance.setex("express" + express.getId(), time, EntityUtils.toString(response.getEntity()));
                    // 返回json
                    return RUtil.setOK("查询成功", instance.get("express" + express.getId()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return RUtil.setERROR("查询失败，请联系人工客服咨询单号是否正确");
    }

    @Override
    public  R<String> addExpress(ExpressDto expressDto) {
        ExpressNumbers express = new ExpressNumbers();
        express.setUserId(expressDto.getUId());
        express.setOrderNumber(expressDto.getOrderNum());
        express.setStoreNumber(expressDto.getStoreNum());
        express.setExpressNumber(expressDto.getExpressNum());
        express.setExpressId(expressDto.getExpressId());
        return RUtil.setR(expressDao.addExpress(express) > 0, "发货操作");
    }
}
