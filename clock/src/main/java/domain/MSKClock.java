package domain;

import java.time.LocalDateTime;

public class MSKClock extends Clock {

    public MSKClock(){
        this.name = "莫斯科";
    }

    @Override
    public void setTime(LocalDateTime date) {
        // date 是北京时间
        // 莫斯科比UTC时间早4小时
        this.date = date.minusHours(5);
    }
//    @Override
//    public void print(){
//        System.out.print(this.name+"时钟时间显示为");
//        System.out.printf("%50s",this.date.toString());
//        System.out.println();
//    }

}
