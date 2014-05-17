package com.zorbit.platform.rbac.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zorbit.platform.core.BaseService;
import com.zorbit.platform.rbac.dao.ModuleDao;
import com.zorbit.platform.rbac.dto.MenuTreeDto;
import com.zorbit.platform.rbac.po.Module;
import com.zorbit.platform.rbac.service.ModuleService;
/**
 * 模块服务实现
 * @since 2014年4月11日 下午11:12:50
 * @author Jamin Zou
 */
@Repository
public class ModuleServiceImpl extends BaseService implements ModuleService {

    @Resource(name="moduleDao")
    private ModuleDao moduleDao;
    @Override
    public  List<Module> getModuleByPersonid(String personid) {
        return moduleDao.getModuleByPersonid(personid);
    }
    @Override
    @Transactional
    public boolean saveOrupdate(Module m) {
      boolean r = false;
      try {
              if(m.isNew()){
                  //m.setUid(UUID.randomUUID().toString());
                  moduleDao.persist(m);
              }else{
                  moduleDao.merge(m);
              }
              r=true;
        } catch (Exception e) {
            e.printStackTrace();
            r=false;
            logger.debug("保存出错："+e.getMessage(), e);
        }
       
        return r;
    }
    @Override
    public Module get(String uid) {
        return moduleDao.find(uid);
    }
    @Override
    public List<MenuTreeDto> findAll() {
        return moduleDao.findAll();
    }
    
}
