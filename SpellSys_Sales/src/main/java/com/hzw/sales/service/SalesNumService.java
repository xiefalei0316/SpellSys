package com.hzw.sales.service;

import com.hzw.sales.dto.SalesNumDto;
import com.qfedu.common.vo.R;

import java.util.List;

public interface SalesNumService {


    R<List<SalesNumDto>> SalesNumTop();
}
