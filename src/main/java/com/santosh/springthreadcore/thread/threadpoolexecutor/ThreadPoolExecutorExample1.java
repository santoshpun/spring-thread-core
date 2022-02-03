package com.santosh.springthreadcore.thread.threadpoolexecutor;

import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component
public class ThreadPoolExecutorExample1 {
    private HandleRejectedThread handleRejectedThread = new HandleRejectedThread();

    public void perform() {

        int corePoolSize = 2;
        int maximumPoolSize = 4;
        // in seconds
        long keepAliveTime = 10;
        int queueCapacity = 2;

        // Wait queue is used to store waiting task
        BlockingQueue queue = new LinkedBlockingQueue(queueCapacity);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                TimeUnit.SECONDS,
                queue,
                handleRejectedThread
        );

        // submit 4 runnable task to thread pool executor service
        for (int i = 1; i <= 4; i++) {

            OrderDispatcherTask orderDispatcherTask = new OrderDispatcherTask(i);

            executor.submit(orderDispatcherTask);
        }

        executor.shutdown();
    }
}
