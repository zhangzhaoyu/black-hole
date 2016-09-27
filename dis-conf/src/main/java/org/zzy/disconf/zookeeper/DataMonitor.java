package org.zzy.disconf.zookeeper;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.data.Stat;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 16-9-23
 * @sine 1.0
 */
public class DataMonitor implements Watcher, AsyncCallback.StatCallback {

    @Override
    public void processResult(int i, String s, Object o, Stat stat) {

    }

    @Override
    public void process(WatchedEvent watchedEvent) {

    }

    public interface DataMonitorListener {
        /**
         * The existence status of the node has changed.
         */
        void exists(byte data[]);

        /**
         * The ZooKeeper session is no longer valid.
         *
         * @param rc
         *                the ZooKeeper reason code
         */
        void closing(int rc);
    }
}
