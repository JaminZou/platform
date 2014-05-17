package com.zorbit.platform.organization.dao;

import com.zorbit.platform.organization.po.Person;


public interface PersonDao {
    Person find(String id);
}
