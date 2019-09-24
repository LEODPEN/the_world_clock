package exception;

import lombok.Getter;

@Getter
public enum ExceptionEnums {
    BAD_CHOICE(-1,"选项键入不正确，请重新键入"),
    PHONE_TIME_NEEDED(-2,"手机时间未设置"),
    TIME_FORMAT_ERROR(-3,"键入时间格式有误"),
    ;

    private Integer code;

    private String message;

    ExceptionEnums(Integer code, String message){
        this.code = code;
        this.message = message;
    }

}
