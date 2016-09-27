package org.zzy.dao.hibernate.inf.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.zzy.dao.hibernate.inf.entity.Item;
import org.zzy.dao.hibernate.inf.entity.Order;

import javax.annotation.Resource;

import java.util.Arrays;
import java.util.List;

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
    @Resource
    private OrderRepository orderRepository;

    @Before
    public void before() {
        if (itemRepository == null) {
            System.out.println("itemRepository is null.");
        }
    }

    @Test
    public void testCascadePersist() {
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        List<Item> items = Arrays.asList(item1, item2);

        Order order = new Order("order1", items);
        order = orderRepository.save(order);
        System.out.println(order);
    }

}