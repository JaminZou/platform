package com.zorbit.platform.rbac.service;

import java.util.List;

import com.zorbit.platform.core.IBaseService;
import com.zorbit.platform.rbac.dto.MenuTreeDto;
import com.zorbit.platform.rbac.po.Module;

/**
 * 模块接口
 * @since 2014年4月11日 下午11:13:15
 * @author Jamin Zou
 */
public interface ModuleService extends IBaseService {
    /**
     * 获得主体拥有权限模块
     * @param personid 主体（人/岗位）id
     * @return
     * @author Jamin Zou
     */
    public List<Module> getModuleByPersonid(String personid);
    
    /**
     * 新增或更新
     * 当m.uid 为空时为新增操作，不为空时为保存操作
     * @param m
     * @return
     * @author Jamin Zou
     */
    public boolean saveOrupdate(Module m);
    
    /**
     * 通过id一个模块对象
     * @param uid
     * @return
     * @author Jamin Zou
     */
    public Module get(String uid);

    /**
     * 得到所有的木块
     * 
     * @author Jamin Zou
     */
    public List<MenuTreeDto> findAll();
}
