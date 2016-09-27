package org.zzy.dao.hibernate.inf.entity;

import javax.persistence.*;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 16-9-18
 * @sine 1.0
 */
@Entity
@Table(name = "t_item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String name;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Order.class, cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "order_id")
    public Order order;

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, Order order) {
        this.name = name;
        this.order = order;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", order=" + order +
                '}';
    }
}
