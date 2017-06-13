package tech.washmore.demo.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author Washmore
 * @version V1.0
 * @summary springboot-junit基类
 * @Copyright (c) 2017, Lianjia Group All Rights Reserved.
 * @since 2017/6/13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class BaseTest {
}
