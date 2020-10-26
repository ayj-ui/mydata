package com.example.mydata.service;


import com.example.mydata.model.Timer;

public interface TimerService {

    public Timer getTimer();

    boolean updateTimer();

    boolean deleteTimer();

    Timer addTimer(Timer timer);



}
