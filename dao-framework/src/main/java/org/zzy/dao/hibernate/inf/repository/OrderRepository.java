package org.zzy.dao.hibernate.inf.repository;

import org.springframework.data.repository.CrudRepository;
import org.zzy.dao.hibernate.inf.entity.Order;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 16-9-19
 * @sine 1.0
 */
public interface OrderRepository extends CrudRepository<Order, Integer> {
}
