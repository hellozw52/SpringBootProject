package com.imooc.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imooc.demo.domain.ZdPerson;

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
     * 查询所有账单人员
     *
     * @return
     */
    List<Map<String, Object>> listZdPerson();

}
