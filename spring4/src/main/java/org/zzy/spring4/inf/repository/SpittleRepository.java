package org.zzy.spring4.inf.repository;

import java.util.List;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 16-9-20
 * @sine 1.0
 */
public interface SpittleRepository<Spittle, Integer> extends Repository {
    List<Spittle> findSpittles(long max, int count);
}
