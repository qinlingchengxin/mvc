package com.yx.schedule;

import org.springframework.stereotype.Service;

/**
 * 定时操作
 */
@Service
public class ScheduleOperateService {

    /**
     * 每小时检查一次是否有过期的订单
     */
    public void abortOrder() {
        System.out.println("abortOrder");
    }

    /**
     * 每天修改一次预约情况
     */
    public void changeBookTime() {
        System.out.println("changeBookTime");
    }

    /**
     * 每小时修改预约情况
     */
    public void changeBookTimeHour() {
        System.out.println("changeBookTimeHour");
    }
}
