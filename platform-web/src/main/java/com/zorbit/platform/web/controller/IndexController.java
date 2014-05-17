package com.zorbit.platform.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zorbit.platform.rbac.dto.MenuTreeDto;
import com.zorbit.platform.rbac.service.ModuleService;

@Controller
public class IndexController extends BaseController {
    
    @Autowired
    private ModuleService moduleService;
    
    @RequestMapping("/index")
    public String index(){
        logger.debug("into index..................");
        return "index";
    }
    
    public Map<String, List<MenuTreeDto>> menus(){
        //moduleService.getModuleByPersonid();
        return null;
    }
}
