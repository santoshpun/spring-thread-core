package com.santosh.springthreadcore.thread.executor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class ScheduledExecutorExample {

    public void perform() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            log.info("Executing Task At " + System.nanoTime());
        };

        log.info("Submitting task at " + System.nanoTime() + " to be executed after 5 seconds.");
        scheduledExecutorService.schedule(task, 5, TimeUnit.SECONDS);

        scheduledExecutorService.shutdown();
    }
}
