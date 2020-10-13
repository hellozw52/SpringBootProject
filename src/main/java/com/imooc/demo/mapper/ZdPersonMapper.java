package com.imooc.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imooc.demo.entity.ZdPerson;

import java.util.List;
import java.util.Map;

public interface ZdPersonMapper extends BaseMapper<ZdPerson> {

    List<Map<String, Object>> listZdPerson();

}
