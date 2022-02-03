package com.santosh.springthreadcore.thread.threadpoolexecutor;

import com.santosh.springthreadcore.thread.util.ThreadUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderDispatcherTask implements Runnable {
    private int orderId;

    public OrderDispatcherTask(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public void run() {
        log.info("Processing order" + orderId);
        ThreadUtil.sleep(5);
    }
}
