package com.zorbit.platform.web.controller.sys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.zorbit.platform.core.utils.DataUtils;
import com.zorbit.platform.rbac.dto.MenuTreeDto;
import com.zorbit.platform.rbac.po.Module;
import com.zorbit.platform.rbac.po.Resource.ResourceType;
import com.zorbit.platform.web.controller.BaseController;

/**
 *菜单管理 
 * @since 2014年4月16日 下午8:05:13
 * @author Jamin Zou
 */
@Controller
@RequestMapping("/sys/menu/")
public class MenuManagerController extends BaseController {
    @RequestMapping(value="treeList",method=RequestMethod.GET)
    public String menuTree(HttpServletRequest req){
        List<MenuTreeDto> trees =serviceManager.getModuleService().findAll();
        List<MenuTreeDto> treesRoot = new ArrayList<MenuTreeDto>();
        menuFormat(trees, treesRoot);
        Gson g = new Gson();
        System.out.println(g.toJson(treesRoot));
        
        return "/sys/menu/menuTree";
    }
    
    /**
     * 菜单详情
     * @param req 
     * @param menuid 菜单id
     * @return
     * @author Jamin Zou
     */
    @RequestMapping(value="menuDetail/{uid}",method=RequestMethod.GET)
    public String menuDetail(HttpServletRequest req,@PathVariable("uid")String menuid){
        if(DataUtils.isUid(menuid)){
            req.setAttribute("entity",serviceManager.getModuleService().get(menuid));
        }
        return "/sys/menu/menuDetail";
    }
    
    /**
     * 新增或保存菜单
     * @param module
     * @return
     * @author Jamin Zou
     */
    @RequestMapping(value="menuSaveOrUpdate",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> menuSaveOrUpdate(Module module){
        Map<String, Object> result = new HashMap<String, Object>();
        if(module.getIleaf()==null ){
            module.setIleaf(0);
        }
        if(!DataUtils.isUid(module.getUid())){
            module.setUid(null);
        }
       boolean f = serviceManager.getModuleService().saveOrupdate(module);
        result.put("result", f);
        result.put("message", f?"保存成功":"保存失败");
        return result;
    }
    /**
     * 把菜单格式化成树状数据结构类
     * @param trees 从数据库中取出来的原始数据，entity.parentid root级为空，其它子项必须有值 ； entity.isleaf 为是否叶子节点必须有值 0/1
     * @param treesRoot 格式化后的 tree root
     * @author Jamin Zou
     */
    protected void menuFormat(List<MenuTreeDto> trees, List<MenuTreeDto> treesRoot) {
        //子项归类
        Map<String, List<MenuTreeDto>> treemap = new HashMap<String, List<MenuTreeDto>>();
        for (MenuTreeDto mt : trees) {
            String parentid = mt.getParentid();
            if(DataUtils.isUid(parentid)){//非第一级
                String key = mt.getParentid();
                List<MenuTreeDto> children = treemap.get(key);
                if(children==null){
                    children =  new ArrayList<MenuTreeDto>();
                    treemap.put(key, children);
                }
                children.add(mt);
            }else {//第一级
                treesRoot.add(mt);
            }
           
        }
        for (MenuTreeDto mt : treesRoot) {
            getMenuChildren(mt,treemap);
        }
    }
    
    /**
     * 递归查找子项
     * @param p 需要查找子项的实体
     * @param data 按 parentid分类的entity 数据map  parentid -- children
     * @author Jamin Zou
     */
    protected void getMenuChildren(MenuTreeDto p,Map<String, List<MenuTreeDto>> data){
        if(!"1".equals(p.getLeaf())){
            List<MenuTreeDto> children = data.get(p.getId());
            p.setChildren(children);
            if(children!=null){
                for (MenuTreeDto menuTreeDto : children) {
                    getMenuChildren( menuTreeDto, data);
                }
            }
          
        }
    }
}
