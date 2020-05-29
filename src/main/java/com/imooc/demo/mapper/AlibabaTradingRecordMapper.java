package com.imooc.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imooc.demo.domain.AlibabaTradingRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
public interface AlibabaTradingRecordMapper extends BaseMapper<AlibabaTradingRecord> {

    /**
     * 交易记录查询
     *
     * @param params
     * @return
     */
    List<Map<String, Object>> getTradeRecordCondition(Map<String, Object> params);

    /**
     * 交易记录查询总个数
     *
     * @param params
     * @return
     */
    int getTradeRecordConditionTotalNum(Map<String, Object> params);

    /**
     * 普通查询
     *
     * @param userId
     * @param commodityName
     * @return
     */
    List<Map<String, Object>> normalQuery(@Param("userId") String userId, @Param("commodityName") String commodityName);
}