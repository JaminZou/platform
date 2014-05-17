package com.zorbit.platform.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zorbit.platform.rbac.service.ModuleService;
/**
 * 服务管理器
 * 所有service层的接口都必须声明在此类中，
 * 在controller中同一 通过 serviceManger.getService.mothod() 调用
 * @since 2014年5月11日 上午10:48:22
 * @author Jamin Zou
 */
@Component("serviceManager")
public class ServiceManager {
    
    /**
     * 模块、菜单服务类
     */
    @Autowired
    private ModuleService moduleService;

    
    /**
     * 获取 模块、菜单服务类
     * @return moduleService
     */
    public ModuleService getModuleService() {
        return moduleService;
    }

    
}
