package org.zzy.dao.hibernate.inf.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 16-9-18
 * @sine 1.0
 */
@Entity
@Table(name = "t_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String name;

    @OneToMany(mappedBy = "order", targetEntity = Item.class, fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    public List<Item> items;

    public Order(String name) {
        this.name = name;
    }

    public Order(String name, List<Item> items) {
        this.name = name;
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", items=" + (items!=null?items.size() : 0) +
                '}';
    }
}
