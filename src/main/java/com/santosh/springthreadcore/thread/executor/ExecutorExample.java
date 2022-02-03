package com.santosh.springthreadcore.thread.executor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class ExecutorExample {

    public void perform() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Runnable task1 = () -> {
            log.info("Running task1 thread : " + Thread.currentThread().getName());
            sleep(5);
            log.info("Completed task1 thread : " + Thread.currentThread().getName());
        };

        Runnable task2 = () -> {
            log.info("Running task2 thread : " + Thread.currentThread().getName());
            sleep(5);
            log.info("Completed task2 thread : " + Thread.currentThread().getName());
        };

        Runnable task3 = () -> {
            log.info("Running task3 thread : " + Thread.currentThread().getName());
            sleep(5);
            log.info("Completed task2 thread : " + Thread.currentThread().getName());
        };

        executorService.submit(task1);
        executorService.submit(task2);
        executorService.submit(task3);

        executorService.shutdown();

        log.info("is shut down : {}", executorService.isShutdown());
    }

    private void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            log.error("Exception ", e);
        }
    }
}
