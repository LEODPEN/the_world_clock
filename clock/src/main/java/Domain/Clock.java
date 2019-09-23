package Domain;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Clock {

    protected LocalDateTime date;

    protected String name;

    void setTime(LocalDateTime date){}

    void print(){
        System.out.println(this.name+"时钟时间显示为:"+this.date.toString());
    }

}
