package com.zorbit.platform.web.controller;

import javax.annotation.Resource;





import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zorbit.platform.web.service.ServiceManager;

public class BaseController {
    /** slf4j*/
    protected static final Logger logger = LoggerFactory.getLogger(BaseController.class);
   @Resource(name ="serviceManager")
   protected ServiceManager serviceManager;
}
