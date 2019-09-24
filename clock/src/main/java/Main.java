import domain.Hotel;
import exception.ExceptionEnums;
import exception.HotelException;
import service.ClockService;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

//    private static ClockService clockService = new ClockService();

//    private Hotel hotel = new Hotel();

    private static void displayChoices(){
        System.out.println("\t\tChoose one option(a/b/c/d): ");
        System.out.println("\t\t\ta. see all clocks.");
        System.out.println("\t\t\t\tb. see phone time.");
        System.out.println("\t\t\t\t\tc. set phone time to reset all clocks.");
        System.out.println("\t\t\t\t\t\td. exit this system.");
        System.out.print("~$: ");
    }

    private static void welcome(Hotel hotel){
        // 每次重新来，反正没存数据...
        System.out.println("\t\t**************************************************");
        System.out.println("\t\t*********Welcome to 码农酒店世界时钟の管理处!*********");
        System.out.println("\t\t**************************************************");
        System.out.println();
    }

    private static void exit(){
        System.out.println("\t\t**************************************************");
        System.out.println("\t\t************Thanks for trying my work!************");
        System.out.println("\t\t**************************************************");
    }

    private static void changeTime(Hotel hotel, ClockService clockService,Scanner in){

        int [] nums = new int[6];
        int i =0;
        System.out.println("\t\tplease choose one mode");
        System.out.println("\t\tIf you input 'a' then current time will be " +
                "set, or you can input time of yourself like 'yyyy mm dd HH mm ss'. ");
        System.out.println("Example-->  Input: 2019 09 24 17 11 02");
        System.out.println("Then ---->   Time: 2019-09-24 17:11:02");
        System.out.print("~$: ");
        in.nextLine();
        String input = in.nextLine();
        if (input.equals("a")||input.equals("A")){
            LocalDateTime dateTime = LocalDateTime.now();
            clockService.setPhoneTime(hotel.getPhone(),dateTime,hotel.getClocks());
        }
        else{
//            String pattern = "^\\d{4}\\s+([0][1-9]|([1][0-2]))\\s+(([0-2]{1}[0-9]{1}|[3]{1}[0-1]{1}))\\s+(([0-1]{1}[0-9]{1})|([2]{1}[0-4]{1})) \\s+ (([0-5]{1}[0-9]{1}|[6]{1}[0]{1})) \\s+ (([0-5]{1}[0-9]{1}|[6]{1}[0]{1}))$";
            String pattern = "^\\d{4}\\s+([0][1-9]|[1][0-2])\\s+([0-2][0-9]{1}|[3][0-1]{1})\\s+([0-1]{1}[0-9]{1}|[2][0-3]{1})\\s+([0-5]{1}[0-9]{1})\\s+([0-5]{1}[0-9]{1})$";
            boolean isMatch = Pattern.matches(pattern, input);

            if (isMatch){
                try {
                    String[] splits = input.split(" ");
                    for (String s : splits){
                        nums[i++] = Integer.parseInt(s);
                    }
                    LocalDateTime dateTime = LocalDateTime.of(nums[0],nums[1],nums[2],nums[3],nums[4],nums[5]);
                    clockService.setPhoneTime(hotel.getPhone(),dateTime,hotel.getClocks());
                }catch (Exception e){
                    // 转换成此异常
                    throw new HotelException(ExceptionEnums.TIME_FORMAT_ERROR);
                }

            }
            else {
                System.out.println(input);
                throw new HotelException(ExceptionEnums.TIME_FORMAT_ERROR);
            }

        }

    }

    private static void choose(Hotel hotel){

        Scanner in = new Scanner(System.in);
        char choice;
        ClockService clockService = new ClockService();
        while (true){
            displayChoices();
            choice = in.next().charAt(0);
            try {
                switch (choice){
                    case 'a':
                    case 'A':
                        clockService.displayDifferentTime(hotel.getClocks());
                        System.out.println();
                        break;
                    case 'b':
                    case 'B':
                        clockService.displayPhoneTime(hotel.getPhone());
                        System.out.println();
                        break;
                    case 'c':
                    case 'C':
                        changeTime(hotel,clockService,in);
                        System.out.println("success!");
                        break;
                    case 'd':
                    case 'D':
                        exit();
                        return;
                    default:
                        throw new HotelException(ExceptionEnums.BAD_CHOICE);
                }
            }catch (Exception e){
                if (e instanceof HotelException){
                    System.out.println("ATTENTION: "+e.getMessage()+"!");
//                    System.out.println("Try it again!");
                }
                else {
                    System.out.println("ATTENTION: 未知异常!");
                    e.printStackTrace();
                }
            }

        }
    }

    // 控制与展示
    public static void main(String[] args){
        Hotel hotel = new Hotel();
        welcome(hotel);
        choose(hotel);
    }

}
