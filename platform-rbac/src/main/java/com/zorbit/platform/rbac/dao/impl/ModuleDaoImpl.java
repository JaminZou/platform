package com.zorbit.platform.rbac.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import com.zorbit.platform.core.BaseDao;
import com.zorbit.platform.rbac.dao.ModuleDao;
import com.zorbit.platform.rbac.dto.MenuTreeDto;
import com.zorbit.platform.rbac.po.Module;

@Component("moduleDao")
public class ModuleDaoImpl extends BaseDao<Module> implements ModuleDao {

    @Override
    public  List<Module> getModuleByPersonid(String personid) {
        StringBuilder sql = new StringBuilder();
        sql.append("select tm.* from tc_module tm where "
        + "exists(select tp.uid from tc_privilege tp where tp.uresourceid=tm.uid and "
                                    + " exists(select tr.uid from tc_role tr where tr.uid=tp.uroleid"
                                    + " exists(select tpr.uid from tc_person_role tpr where tpr.uroleid=tr.uid and tpr.upersonid=?)))");
       List<Module> modules = this.jdbcTemplate.queryForList(sql.toString(),  new Object[]{personid}, Module.class);
        return modules;
    }

    @Override
    public List<MenuTreeDto> findAll(){
        StringBuilder sql = new StringBuilder();
        sql.append("select tr.uparentid parentid,tm.uid id,tr.cname name,tm.cicon icon,tm.curl url,tr.ilevel level" );
        sql.append(",(case tr.ileaf when 1 then 'item' else 'folder' end) type,tr.ileaf leaf,tr.nordernum ordernum " );
        sql.append("from tc_module tm,tc_resource tr   ");
        sql.append(" where tr.uid=tm.uid");
        sql.append(" group by tr.uparentid,tm.uid,tr.cname,tm.cicon,tm.curl,tr.ilevel,tr.ileaf,tr.nordernum order by tr.nordernum ");
        List<Map<String, Object>> modulesMap = this.jdbcTemplate.queryForList(sql.toString());
        List<MenuTreeDto> modules = convertData(modulesMap,MenuTreeDto.class);
        return modules;
    }

}
