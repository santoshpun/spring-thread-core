package com.santosh.springthreadcore.thread.executor.callable;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
@Component
public class CallableExecutorExample1 {

    public void perform() {
        try {
            ExecutorService executor = Executors.newFixedThreadPool(1);

            Callable<Integer> callableTask = new RectangleAreaTask(100, 200);

            // Callable thread submitted to return callable response after completing thread's task
            Future<Integer> future = executor.submit(callableTask);

            executor.shutdown();

            // Wait until all threads are finished
            while (!executor.isTerminated()) {

                Integer result = future.get();

                log.info("Result : {}", result);
            }

            log.info("Thread execution completed");

        } catch (Exception e) {
            log.error("Exception ", e);
        }
    }
}
