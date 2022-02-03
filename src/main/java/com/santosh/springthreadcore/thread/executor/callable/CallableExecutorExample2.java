package com.santosh.springthreadcore.thread.executor.callable;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
@Component
public class CallableExecutorExample2 {

    public void perform() {
        try {
            ExecutorService executor = Executors.newFixedThreadPool(2);

            List<Future<Integer>> futureList = new ArrayList<>();

            log.info("Threads submitted..");

            for (int i = 1; i <= 2; i++) {

                Callable<Integer> callableTask = new RectangleAreaTask(100 * i, 200 * i);

                // get callable task response in future object
                Future<Integer> future = executor.submit(callableTask);

                // add future to list
                futureList.add(future);
            }

            for (Future<Integer> future : futureList) {

                // future.get() blocks until the result is available
                Integer result = future.get();

                log.info("Result : {}", result);
            }

            executor.shutdown();

            log.info("All threads finished processing..");

        } catch (Exception e) {
            log.error("Exception ", e);
        }
    }
}
