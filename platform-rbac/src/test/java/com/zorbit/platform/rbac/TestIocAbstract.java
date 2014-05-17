package com.zorbit.platform.rbac;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;


@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class })
@ContextConfiguration(locations = {
        "classpath*:META-INF/spring/applicationContext.xml",
        "classpath*:META-INF/spring/applicationContext-rbac.xml",
        "classpath:META-INF/spring/applicationContext-org.xml",
        "classpath:applicationContext*.xml" })
public class TestIocAbstract {
    
}
