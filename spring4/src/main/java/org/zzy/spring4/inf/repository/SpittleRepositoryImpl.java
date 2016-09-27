package org.zzy.spring4.inf.repository;

import org.springframework.stereotype.*;

import java.util.List;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 16-9-20
 * @sine 1.0
 */
@org.springframework.stereotype.Repository
public class SpittleRepositoryImpl implements SpittleRepository {
    @Override
    public List findSpittles(long max, int count) {
        return null;
    }
}
