package domain;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class Clock {

    // 考虑可扩展性(例如shape)，采取继承

    protected LocalDateTime date;

    protected String name;

    public void setTime(LocalDateTime date){}

    public void print(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.printf("%50s",this.name+"时钟时间显示为\t\t\t"+this.date.format(formatter));
        System.out.println();
    }
}
