package domain;

import java.time.LocalDateTime;

public class BJClock extends Clock {

    public BJClock(){
        this.name = "北京";
    }

    @Override
    public void setTime(LocalDateTime date) {
        // date 是北京时间
        this.date = date;
    }

//    @Override
//    void print(){
//        System.out.println(this.name+"时钟时间显示为:"+this.date.toString());
//    }
}
