package org.zzy.concurrent.shareresource;

/**
 * Created by zhaoyu on 16-9-2.
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;

    public abstract int next();

    public void cancel() {
        this.canceled = true;
    }

    public boolean isCancel() {
        return this.canceled;
    }
}
