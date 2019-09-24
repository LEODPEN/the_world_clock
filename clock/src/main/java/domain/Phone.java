package domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class Phone extends Clock {

    // 未用到
    private String phoneNumber;

    @Override
    public void setDate(LocalDateTime date) {
        // date 是北京时间
        this.date = date;
    }

    @Override
    public void print(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.printf("%50s","管理员手机目前时间显示为\t\t\t"+ this.date.format(formatter));
        System.out.println();
    }
}
