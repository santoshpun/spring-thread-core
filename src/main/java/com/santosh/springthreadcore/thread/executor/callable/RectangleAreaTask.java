package com.santosh.springthreadcore.thread.executor.callable;

import com.santosh.springthreadcore.thread.util.ThreadUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

@Slf4j
public class RectangleAreaTask implements Callable<Integer> {
    private int length;
    private int width;

    public RectangleAreaTask(int length, int width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public Integer call() throws Exception {

        ThreadUtil.sleep(5);

        int area = this.length * this.width;

        log.info(String.format("Area of a rectangle is %s", area));

        return area;
    }
}
