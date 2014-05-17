package com.zorbit.platform.core;



import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zorbit.platform.core.utils.BeanUtils;
import com.zorbit.platform.core.utils.Generics;

/**
 * 到层查询基类
 * @param <M> extends IdEntity
 * @since 2013年8月11日 下午7:56:04
 * @author Jamin Zou
 */
public class BaseDao<M extends IdEntity> implements IBaseDao<M> {
    /** slf4j*/
    protected static final Logger logger = LoggerFactory.getLogger(BaseDao.class);
    /**形参类型*/
    private Class<M> model;
    @PersistenceContext
    protected EntityManager entityManager;
    
    @Resource(name="jdbcTemplate")
    protected JdbcTemplate jdbcTemplate;

    @SuppressWarnings("unchecked")
    public BaseDao() {
        if (model == null) {
            try {
                model = (Class<M>) Generics.getTypeParameterClass(this.getClass());
            } catch (Exception e) {
                throw new RuntimeException("无法获取实体类型", e);
            }
        }
        logger.error("erro:"+model);
    }
    
    public void persist(M m){
        entityManager.persist(m);
    }
    @Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
    public M find(String id) {
        return (M) entityManager.find(model, id);
    }

    public void remove(String id) {
        entityManager.remove(entityManager.find(model, id));
    }

    public void merge(M m) {
        entityManager.merge(m);
    }
    
    /**
     * 转换数据
     * @param modulesMap spring jdbc结果集
     * @param m entity
     * @return
     * @author Jamin Zou
     * @param <T>
     */
    protected <T> List<T> convertData(List<Map<String, Object>> modulesMap,Class<T> m) {
        List<T> modules = new ArrayList<T>();
        try {
            for (Map<String, Object> map : modulesMap) {
                Map<String, Object> mp= new HashMap<String, Object>();
                for (String t : map.keySet()) {
                    mp.put(t.toLowerCase(), map.get(t));
                }
               T m1 = m.newInstance();
               BeanUtils.getBeanUtils().populate(m1, mp);
                modules.add(m1);
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            logger.debug("数据映射出错", e);
            e.printStackTrace();
        } catch (InstantiationException e) {
            logger.debug("数据映射出错", e);
            e.printStackTrace();
        }
        return modules;
    }
}
