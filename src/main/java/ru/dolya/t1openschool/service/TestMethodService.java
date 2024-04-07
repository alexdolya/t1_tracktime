package ru.dolya.t1openschool.service;

import ru.dolya.t1openschool.annotation.TrackAsyncTime;
import ru.dolya.t1openschool.annotation.TrackTime;

public interface TestMethodService {
    @TrackTime
    void testMethodWithTrackTimeAnnotation(int numOfCall);

    @TrackAsyncTime
    void testMethodWithTrackTimeAsyncAnnotation(int numOfCall);


}
