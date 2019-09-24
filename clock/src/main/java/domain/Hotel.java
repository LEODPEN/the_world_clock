package domain;

import lombok.Data;
import java.util.ArrayList;

@Data
public class Hotel {

//    private static final int CLOCK_NUM = 5; // 酒店时钟数

    private final String NAME = "码农酒店";

    private Phone phone;

    private ArrayList<Clock> clocks; // 五个世界时钟

    public Hotel(){
        // 初始化手机和5个世界时钟
        phone = new Phone();
        // 这里注意NullPointerException
        clocks = new ArrayList<>();
        clocks.add( new BJClock());
        clocks.add( new LDClock());
        clocks.add(new MSKClock());
        clocks.add(new NYClock());
        clocks.add(new XNClock());
        // 未要求展示时间时，不展示时间，因此不采取时间的初始化
    }

}
