package com.imooc.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imooc.demo.entity.ZdPerson;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 账户信息表 服务类
 * </p>
 *
 * @author hellozw
 * @since 2020-05-15
 */
public interface ZdPersonService extends IService<ZdPerson> {

    /**
     * @Description 查询所有账单人员
     * @Author zw
     * @Date 2020/10/13 15:53
     * @Param []
     * @Return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
    **/
    List<Map<String, Object>> listZdPerson();

}
