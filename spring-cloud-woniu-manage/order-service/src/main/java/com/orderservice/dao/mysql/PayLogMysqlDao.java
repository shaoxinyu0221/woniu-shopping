package com.orderservice.dao.mysql;

import com.orderservice.web.fo.PayLogFo;
import com.orderservice.web.dto.PayLogDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 邵鑫雨
 * @version 1.0
 * @description: TODO
 * @date 2022/8/13 14:41
 */
@Mapper
public interface PayLogMysqlDao {

    List<PayLogDto> getPayLog(PayLogFo payLogFo);
}
