package org.zzy.disconf.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 16-9-23
 * @sine 1.0
 */
public class Executor implements Watcher, Runnable, DataMonitor.DataMonitorListener {

    String zNode;
    DataMonitor dataMonitor;
    ZooKeeper zooKeeper;
    String fileName;
    String[] exec;
    Process child;

    public Executor(String hostPort, String zNode, String fileName, String[] exec) throws IOException {
        this.fileName = fileName;
        this.exec = exec;
        zooKeeper = new ZooKeeper(hostPort, 3000, this);
        dataMonitor = new DataMonitor();
    }

    @Override
    public void run() {

    }

    @Override
    public void process(WatchedEvent watchedEvent) {

    }

    @Override
    public void exists(byte[] data) {

    }

    @Override
    public void closing(int rc) {

    }
}
