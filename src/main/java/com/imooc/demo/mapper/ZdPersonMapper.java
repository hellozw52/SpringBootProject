package com.imooc.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imooc.demo.domain.ZdPerson;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 账户信息表 Mapper 接口
 * </p>
 *
 * @author hellozw
 * @since 2020-05-15
 */
public interface ZdPersonMapper extends BaseMapper<ZdPerson> {

    List<Map<String, Object>> listZdPerson();

}
