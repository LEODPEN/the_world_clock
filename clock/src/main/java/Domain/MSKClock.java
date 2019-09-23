package Domain;

import java.time.LocalDateTime;

public class MSKClock extends Clock{

    public MSKClock(){
        this.name = "莫斯科";
    }

    @Override
    void setTime(LocalDateTime date) {
        // date 是北京时间
        // 莫斯科比UTC时间早4小时
        this.date = date.minusHours(4);
    }
}
