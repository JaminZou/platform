package com.zorbit.platform.rbac.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.zorbit.platform.core.IBaseDao;
import com.zorbit.platform.rbac.dto.MenuTreeDto;
import com.zorbit.platform.rbac.po.Module;


public interface ModuleDao extends IBaseDao<Module> {

    /**
     * 获得主体拥有权限模块
     * @param personid 主体（人/岗位）id
     * @return
     * @author Jamin Zou
     */
   public  List<Module> getModuleByPersonid(String personid);

   /**
    * 得到所有的模块菜单
    * @return
    * @author Jamin Zou
 * @throws InvocationTargetException 
 * @throws IllegalAccessException 
    */
   public List<MenuTreeDto> findAll();
    
}
