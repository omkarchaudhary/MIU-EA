package edu.miu.ea.springpractice.service;

import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;

@Service
public class DateService {

    private int SATURDAY= 7;
    private int SUNDAY= 1;

    public int getDayNumber() {
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(new Date());
        return  calendar.get(Calendar.DAY_OF_WEEK);
    }

    public boolean isTodayWeekend() {
        int dayNumber= getDayNumber();
        if ((dayNumber == SATURDAY) || (dayNumber == SUNDAY)) {
            return true;
        }
        return false;
    }
}
