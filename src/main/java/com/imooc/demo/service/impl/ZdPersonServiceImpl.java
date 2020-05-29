package com.imooc.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imooc.demo.domain.ZdPerson;
import com.imooc.demo.mapper.ZdPersonMapper;
import com.imooc.demo.service.ZdPersonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 账户信息表 服务实现类
 * </p>
 *
 * @author hellozw
 * @since 2020-05-15
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ZdPersonServiceImpl extends ServiceImpl<ZdPersonMapper, ZdPerson> implements ZdPersonService {

    @Resource
    protected ZdPersonMapper zdPersonMapper;

    @Override
    public List<Map<String, Object>> listZdPerson() {
        return zdPersonMapper.listZdPerson();
    }
}
