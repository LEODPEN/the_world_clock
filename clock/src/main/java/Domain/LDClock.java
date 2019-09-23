package Domain;

import java.time.LocalDateTime;

public class LDClock extends Clock {

    public LDClock(){
        this.name = "伦敦";
    }

    @Override
    void setTime(LocalDateTime date) {
        // date 是北京时间
        // 伦敦与UTC时间一致，北京比UTC时间早8小时
        this.date = date.minusHours(8);
    }

}
