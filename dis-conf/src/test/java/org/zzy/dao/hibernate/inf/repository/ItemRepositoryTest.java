package org.zzy.dao.hibernate.inf.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 16-9-18
 * @sine 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:application-context/hibernate/persistence.xml"
})
@Transactional
public class ItemRepositoryTest {

    @Resource
    private ItemRepository itemRepository;

    @Before
    public void before() {
        if (itemRepository == null) {
            System.out.println("itemRepository is null.");
        }
    }

    @Test
    public void testCascadePersist() {
        System.out.println(itemRepository + "----------------------------");
    }

}