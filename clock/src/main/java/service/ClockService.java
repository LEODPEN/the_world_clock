package service;

import domain.Clock;
import domain.Phone;
import exception.ExceptionEnums;
import exception.HotelException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ClockService {

    public void setPhoneTime(Phone phone, LocalDateTime dateTime, ArrayList<Clock> clocks){
        phone.setDate(dateTime);
        setTimeByPhone(phone,clocks);
    }

    public void displayPhoneTime(Phone phone) {
        // 如果phone未初始化时间
        if (phone.getDate()==null){
            throw new HotelException(ExceptionEnums.PHONE_TIME_NEEDED);
        }
        phone.print();
    }

    public void setTimeByPhone(Phone phone, ArrayList<Clock> clocks){
        LocalDateTime dateTime = phone.getDate();
        for (Clock clock : clocks){
            clock.setTime(dateTime);
        }
    }

    public void displayDifferentTime(ArrayList<Clock> clocks){
        // 如果无初始化时间，展示现在
        LocalDateTime localDateTime = LocalDateTime.now();

        for (Clock clock : clocks){
            if (clock.getDate()==null){
                // 一起设置的，故不考虑不一致情况
                clock.setTime(localDateTime);
            }
            // 打印时钟时间
            clock.print();
        }

    }
}
