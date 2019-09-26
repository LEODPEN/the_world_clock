package service;

import domain.Clock;
import domain.Hotel;
import exception.ExceptionEnums;
import exception.HotelException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class ClockServiceTest {

    private ClockService clockService;

    private Hotel hotel;

    @BeforeEach
    void beginActions(){
        this.clockService = new ClockService();
        this.hotel = new Hotel();
//        System.out.println("初始化操作done。");
    }

    @Test
    void setPhoneTimeTest() {
        LocalDateTime dateTime = LocalDateTime.of(2018,11,22,8,55,44);
        clockService.setPhoneTime(hotel.getPhone(),dateTime,hotel.getClocks());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String phoneDateTime = hotel.getPhone().getDate().format(formatter);
        String needDateTime  = "2018-11-22 08:55:44";
        assertEquals(needDateTime,phoneDateTime);

    }

    @Test
    void displayPhoneTimeTest1() {
        // 此时应该没初始化
        clockService.displayPhoneTime(hotel.getPhone());
        HotelException exception =  assertThrows(HotelException.class,() -> {
            clockService.displayPhoneTime(hotel.getPhone());
        });

        assertEquals(ExceptionEnums.PHONE_TIME_NEEDED.getCode(),exception.getError_code());
    }

    @Test
    void displayPhoneTimeTest2(){
        LocalDateTime dateTime = LocalDateTime.of(2018,11,22,8,55,44);
        clockService.setPhoneTime(hotel.getPhone(),dateTime,hotel.getClocks());
        assertDoesNotThrow(() -> {
            clockService.displayPhoneTime(hotel.getPhone());
        });
    }

    @Test
    void setByPhoneTimeTest() {
        LocalDateTime dateTime = LocalDateTime.of(2018,11,22,8,55,44);
        hotel.getPhone().setDate(dateTime);
        clockService.setTimeByPhone(hotel.getPhone(),hotel.getClocks());
        assertEquals(dateTime,hotel.getClocks().get(0).getDate());
    }
}
