package com.example.mydata.service.impl;

import com.example.mydata.dao.TimerMapper;
import com.example.mydata.model.Timer;
import com.example.mydata.service.TimerService;

public class TimerServiceImpl implements TimerService {

   /* @Override*/
    private TimerMapper timerMapper;

    @Override
    public Timer getTimer() {
        return null;
    }

    @Override
    public boolean updateTimer() {
        return false;
    }

    @Override
    public boolean deleteTimer() {
        return false;
    }

    @Override
    public Timer addTimer(Timer timer) {
        int timer1 = timerMapper.insert(timer);

        return  null;
    }
}
