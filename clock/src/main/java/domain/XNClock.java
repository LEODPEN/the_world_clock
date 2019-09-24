package domain;

import java.time.LocalDateTime;

public class XNClock extends Clock {

    public XNClock(){
        this.name = "悉尼";
    }

    @Override
    public void setTime(LocalDateTime date) {
        // date 是北京时间
        // 悉尼比UTC时间早10小时
        this.date = date.plusHours(2);
    }
}
