package com.zorbit.platform.organization.dao.impl;

import org.springframework.stereotype.Service;

import com.zorbit.platform.core.BaseDao;
import com.zorbit.platform.organization.dao.PersonDao;
import com.zorbit.platform.organization.po.Person;

@Service
public class PersonDaoImpl extends BaseDao<Person> implements PersonDao {

    public PersonDaoImpl() {
       System.out.println("----------------------");
    }
    
}
