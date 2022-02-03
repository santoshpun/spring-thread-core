package com.santosh.springthreadcore.thread.threadpoolexecutor;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

@Slf4j
public class HandleRejectedThread implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        log.error("Thread {} is rejected due to no availability of threads in a pool to process", r.toString());
    }
}
