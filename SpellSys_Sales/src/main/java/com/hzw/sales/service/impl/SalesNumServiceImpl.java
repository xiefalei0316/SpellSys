package com.hzw.sales.service.impl;

import com.alibaba.fastjson.JSON;
import com.hzw.sales.cache.JedisUtil;
import com.hzw.sales.config.RedisKeyConfig;
import com.hzw.sales.dao.SalesNumDao;
import com.hzw.sales.dto.SalesNumDto;
import com.hzw.sales.service.SalesNumService;
import com.qfedu.common.util.RUtil;
import com.qfedu.common.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class SalesNumServiceImpl implements SalesNumService {


    private JedisUtil jedisUtil=JedisUtil.getInstance();
    @Autowired(required = false)
    private SalesNumDao salesNumDao;

    @Override
    public R<List<SalesNumDto>> SalesNumTop() {
        Map<String, String> map = jedisUtil.hgetall(RedisKeyConfig.LOOKTOP);
        if (map == null || map.size() == 0){
            List<SalesNumDto> list = salesNumDao.selectSalesNumTop();
            map = new HashMap<>();
            for (int i = 0;i < list.size();i ++){
                map.put(i+1+"", JSON.toJSONString(list.get(i)));
            }
            jedisUtil.hmset(RedisKeyConfig.LOOKTOP,map);
            return RUtil.setOK("OK",list);
        } else {
            ArrayList<SalesNumDto> list = new ArrayList<>();
            for (String k:map.keySet()){
                String s =map.get(k);
                list.add(JSON.parseObject(s,SalesNumDto.class));
            }
            return RUtil.setOK("OK",list);
        }
    }
}
