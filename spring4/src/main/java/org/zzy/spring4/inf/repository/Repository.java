package org.zzy.spring4.inf.repository;

import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 16-9-20
 * @sine 1.0
 */
public interface Repository<T, ID extends Serializable> {
}
