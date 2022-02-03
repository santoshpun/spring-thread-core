package com.santosh.springthreadcore;

import com.santosh.springthreadcore.thread.executor.ExecutorExample;
import com.santosh.springthreadcore.thread.executor.ScheduledExecutorExample;
import com.santosh.springthreadcore.thread.executor.callable.CallableExecutorExample1;
import com.santosh.springthreadcore.thread.executor.callable.CallableExecutorExample2;
import com.santosh.springthreadcore.thread.threadpoolexecutor.ThreadPoolExecutorExample1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Starter implements CommandLineRunner {
    @Autowired
    private ExecutorExample executorExample;
    @Autowired
    private ScheduledExecutorExample scheduledExecutorExample;

    @Autowired
    private CallableExecutorExample1 callableExecutorExample1;
    @Autowired
    private CallableExecutorExample2 callableExecutorExample2;

    @Autowired
    private ThreadPoolExecutorExample1 threadPoolExecutorExample1;


    @Override
    public void run(String... args) throws Exception {
        this.testExecutorThreads();
        this.testExecutorCallableThreads();
        this.testThreadPoolExecutorThreads();
    }

    private void testExecutorThreads() {
        executorExample.perform();
        scheduledExecutorExample.perform();
    }

    private void testExecutorCallableThreads() {
        callableExecutorExample1.perform();
        callableExecutorExample2.perform();
    }

    private void testThreadPoolExecutorThreads() {
        threadPoolExecutorExample1.perform();
    }
}
