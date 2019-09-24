package domain;

import java.time.LocalDateTime;

public class NYClock extends Clock {

    public NYClock(){
        this.name = "纽约";
    }

    @Override
    public void setTime(LocalDateTime date) {
        // date 是北京时间
        // 纽约比UTC时间晚5小时
        this.date = date.minusHours(13);
    }
}
